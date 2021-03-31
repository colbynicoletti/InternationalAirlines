package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TicketTest {

  private static Ticket testTicket;

  @BeforeAll
  public static void initializeVariables() {
    testTicket = new Ticket();
  }

  @Test
  public void testZeroPrice_ThrowsException() {
    assertThrows(Exception.class, () -> testTicket.calculateCost(0, 1));
  }

  @Test
  public void testNegativeSeats_ThrowsException() {
    assertThrows(Exception.class, () -> testTicket.calculateCost(15,-1));
  }

  @Test
  public void testValidInput_NoExceptionThrown() throws Exception {
    assertEquals(testTicket.calculateCost(15,2), 30);
  }
}