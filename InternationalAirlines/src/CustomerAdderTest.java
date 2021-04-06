package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.*;

/** @author Nick Gadomski, Jose Ruiz-Ramon, Ben Deleuze, Colby Nicoletti
 This is the test suite for the customer adder. **/
public class CustomerAdderTest {

  private CustomerAdder testCustomerAdder = new CustomerAdder();
  private String firstName;
  private String lastName;
  private String nic;
  private String passport;
  private String address;
  private String date;
  private String contact;
  private String gender;

  @BeforeEach
  public void setValidInput() {
    firstName = "Ben";
    lastName = "Deleuze";
    nic = "12345678";
    passport = "A2096457";
    address = "1 Liberty St";
    Date dDate = new Date(System.currentTimeMillis());
    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    date = da.format(dDate);
    contact = "9549376477";
    gender = "Male";
  }

  @Test
  public void testInvalidFirstName_ThrowsException()
  {
    firstName = "123SUCK";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void TestInvalidLastName_ThrowsException()
  {
    lastName = "!@#MY";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void TestInvalidNic_ThrowsException()
  {
    nic = "(*)(*)";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void TestInvalidPassport_ThrowsException()
  {
    passport = "APR1234";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void TestInvalidAddress_ThrowsException()
  {
    address = "8008 san carlos";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void TestInvalidDate_ThrowsException()
  {
    date = "";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void TestInvalidContact_ThrowsException()
  {
    contact = "12345678901234";
    assertThrows(Exception.class, () -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }

  @Test
  public void testAllValid_NoExceptionThrown() throws Exception
  {
    assertDoesNotThrow(() -> testCustomerAdder
            .testInputForNewCustomer(firstName, lastName, nic, passport, address, date, contact,
                    gender));
  }
}