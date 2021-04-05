package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.*;

class TicketTest {

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
    //check if info is correct
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

  @Test
  public void testTicketValidInput_NoExceptionThrown() {
    assertDoesNotThrow(() -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidTextId_ThrowsException() {
    textId = "Please";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidFlightId_ThrowsException() {
    flightId = "Don't";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidCustomerId_ThrowsException() {
    customerId = "Crash";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidFlightClass_ThrowsException() {
    flightClass = "Into";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidPrice_ThrowsException() {
    price = "-500";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidSeats_ThrowsException() {
    seats = "0";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testInvalidDate_ThrowsException() {
    date = "09-11-2001";
    assertThrows(Exception.class, () -> testTicket
        .testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date));
  }

  @Test
  public void testZeroPrice_ThrowsException() {
    assertThrows(Exception.class, () -> testTicket.calculateCost(0, 1));
  }

  @Test
  public void testNegativeSeats_ThrowsException() {
    assertThrows(Exception.class, () -> testTicket.calculateCost(15, -1));
  }

  @Test
  public void testCoastValidInput_NoExceptionThrown() throws Exception {
    assertEquals(testTicket.calculateCost(15, 2), 30);
  }
}