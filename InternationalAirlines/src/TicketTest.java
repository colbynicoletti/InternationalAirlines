package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.*;

class TicketTest {

  private Ticket testTicket = new Ticket();
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
    customerId = "CS001";
    flightClass = "Economy";
    price = "500";
    seats = "1";
    Date dDate = new Date(System.currentTimeMillis());
    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    date = da.format(dDate);
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