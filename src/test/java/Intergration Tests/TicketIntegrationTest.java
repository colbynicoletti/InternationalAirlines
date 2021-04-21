import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TicketIntegrationTest {

    private Ticket testTicket = new Ticket();
    Connection con;
    PreparedStatement pst;
    private String textId;
    private String flightId;
    private String customerId;
    private String flightClass;
    private String price;
    private String seats;
    private String date;

    @BeforeEach
    public void setValidInputs() {
        textId = "TO001";
        flightId = "FO001";
        customerId = "CS000";
        flightClass = "Economy";
        price = "500";
        seats = "1";
        Date dDate = new Date(System.currentTimeMillis());
        DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        date = da.format(dDate);
    }

    @Test
    public void integrationTest_addToDB_Using_TicketMock() {
        //create mock TicketReport object
        Ticket mockTicket = Mockito.spy(new Ticket());
        ActionEvent evt = new ActionEvent(mockTicket, 1, "");
        mockTicket.setTextTicketNumber(textId);
        mockTicket.setFlightNumber(flightId);
        mockTicket.setTextCustomerId(customerId);
        mockTicket.setTxtclass(flightClass);
        mockTicket.setTextPrice(price);
        mockTicket.setTextSeats(seats);

        //Prevent the LoadData from being used but still called.
        Mockito.doReturn(true).when(mockTicket)
                .addTicketToDB(textId, flightId, customerId, flightClass, price, seats, date);
        //call initComponents (tested method)  to see if it loads data
        mockTicket.submitButtonAction(evt);
        //Check to see if the LoadData has been accessed.
        verify(mockTicket, times(1))
                .addTicketToDB(textId, flightId, customerId, flightClass, price, seats, date);
    }

    @Test
    public void integrationTestSearchFlightInDB_NoExceptionThrown() throws SQLException {
        //set test variables
        String id = "TestID", flightName = "TestFlightName", source = "TestSource", depart = "TestDepart",
                date = "TestDate", departTime = "TestDepartTime", arrivalTime = "TestArrivalTime",
                flightCharge = "TestFlightCharge";
        ArrayList<Vector> testFlightList = new ArrayList<>();
        Vector testFlightVector = new Vector();
        testFlightVector.add(id);
        testFlightVector.add(flightName);
        testFlightVector.add(source);
        testFlightVector.add(depart);
        testFlightVector.add(date);
        testFlightVector.add(departTime);
        testFlightVector.add(arrivalTime);
        testFlightVector.add(flightCharge);
        testFlightList.add(testFlightVector);
        //add test flight to DB
        con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
        pst = con.prepareStatement(
                "INSERT INTO flight (id, flightname, source, depart, date, deptime, arrtime, flightcharge) VALUES (?,?,?,?,?,?,?,?)");
        pst.setString(1, id);
        pst.setString(2, flightName);
        pst.setString(3, source);
        pst.setString(4, depart);
        pst.setString(5, date);
        pst.setString(6, departTime);
        pst.setString(7, arrivalTime);
        pst.setString(8, flightCharge);
        pst.executeUpdate();
        //check if into was added to DB correctly
        assertEquals(testFlightList, testTicket.getFlightsFromDB(source, depart));
        //remove added test flight from DB
        pst = con.prepareStatement("DELETE FROM flight WHERE id = ?");
        pst.setString(1, id);
        pst.executeUpdate();
    }

    @Test
    public void integrationTestSearchCustomerInDB_NoExceptionThrown() throws SQLException {
        String[] customerInfo = {"TestFirstName", "TestLastName", "TestPassportNumber"};
        String[] dbCustomerInfo;
        String id = "CS000";
        String nic = "TestNic";
        String address = "TestAdress";
        String dob = "TestDOB";
        String gender = "TestGender";
        int contact = 0000000000;
        byte[] photo = {1};

        //add test customer to DB
        con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
        pst = con.prepareStatement(
                "INSERT INTO customer (id, firstname, lastname, nic, passport, address, dob, gender, contact, photo) VALUES (?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, id);
        pst.setString(2, customerInfo[0]);
        pst.setString(3, customerInfo[1]);
        pst.setString(4, nic);
        pst.setString(5, customerInfo[2]);
        pst.setString(6, address);
        pst.setString(7, dob);
        pst.setString(8, gender);
        pst.setInt(9, contact);
        pst.setBytes(10, photo);
        pst.executeUpdate();
        //check if into was added to DB correctly
        dbCustomerInfo = testTicket.getCustomerInfoFromDB(id);
        assertEquals(dbCustomerInfo[0], customerInfo[0]);
        assertEquals(dbCustomerInfo[1], customerInfo[1]);
        assertEquals(dbCustomerInfo[2], customerInfo[2]);
        //remove added customer from DB
        pst = con.prepareStatement("DELETE FROM customer WHERE id = ? AND firstname = ?");
        pst.setString(1, id);
        pst.setString(2, customerInfo[0]);
        pst.executeUpdate();
    }

    @Test
    public void integrationTestAddTicketToDB_NoExceptionThrown() throws SQLException {
        assertTrue(
                testTicket.addTicketToDB(textId, flightId, customerId, flightClass, price, seats, date));

        //collect what was added to DB
        con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
        pst = con.prepareStatement(
                "select id,flightid,custid,class,price,seats,date from ticket WHERE id = ? AND custid = ?");
        pst.setString(1, textId);
        pst.setString(2, customerId);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String dbTextId = rs.getString("id");
        String dbFlightId = rs.getString("flightid");
        String dbCustomerID = rs.getString("custid");
        String dbFlightClass = rs.getString("class");
        String dbPrice = rs.getString("price");
        String dbSeats = rs.getString("seats");
        String dbDate = rs.getString("date");

        //test if what was added was correct
        assertEquals(dbTextId, textId);
        assertEquals(dbFlightId, flightId);
        assertEquals(dbCustomerID, customerId);
        assertEquals(dbFlightClass, flightClass);
        assertEquals(dbPrice, price);
        assertEquals(dbSeats, seats);
        assertEquals(dbDate, date);

        //remove test data from DB
        pst = con.prepareStatement("DELETE FROM ticket WHERE id = ? AND custid = ?");
        pst.setString(1, textId);
        pst.setString(2, customerId);
        pst.executeUpdate();
    }
}
