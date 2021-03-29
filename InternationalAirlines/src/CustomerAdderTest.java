package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.jupiter.api.*;

public class CustomerAdderTest {

  private static CustomerAdder testCustomerAdder;
  private static ActionEvent evt;

  @BeforeAll
  public static void initializeVariables() {
    testCustomerAdder = new CustomerAdder();
    evt = new ActionEvent(testCustomerAdder, 1, "");

    //set valid input
    JTextField firstName = new JTextField("Ben");
    JTextField lastName = new JTextField("Deleuze");
    JTextField nic = new JTextField("12345678");
    JTextField passport = new JTextField("A2096457");
    JTextArea address = new JTextArea("1 Liberty St");
    Date dDate = new Date(System.currentTimeMillis());
    JDateChooser date = new JDateChooser(dDate);
    JTextField contact = new JTextField("9549376477");
    testCustomerAdder.setTxtfirstname(firstName);
    testCustomerAdder.setTxtlastname(lastName);
    testCustomerAdder.setTxtnic(nic);
    testCustomerAdder.setTxtpassport(passport);
    testCustomerAdder.setTxtaddress(address);
    testCustomerAdder.setTxtdob(date);
    testCustomerAdder.setTxtcontact(contact);
  }

  @Test
  public void testInvalidFirstName_ThrowsException() {
    JTextField firstName = new JTextField("123SUCK");
    testCustomerAdder.setTxtfirstname(firstName);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

  @Test
  public void TestInvalidLastName_ThrowsException() {
    JTextField lastName = new JTextField("!@#MY");
    testCustomerAdder.setTxtlastname(lastName);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

  @Test
  public void TestInvalidNic_ThrowsException() {
    JTextField nic = new JTextField("(*)(*)");
    testCustomerAdder.setTxtnic(nic);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

  @Test
  public void TestInvalidPassport_ThrowsException() {
    JTextField passport = new JTextField("APR1234");
    testCustomerAdder.setTxtpassport(passport);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

  @Test
  public void TestInvalidAddress_ThrowsException() {
    JTextArea address = new JTextArea("8008 san carlos");
    testCustomerAdder.setTxtaddress(address);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

  @Test
  public void TestInvalidDate_ThrowsException() {
    String strDate = "";
    Date dDate = new Date();
    JDateChooser date = new JDateChooser(dDate, strDate);
    testCustomerAdder.setTxtdob(date);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

  @Test
  public void TestInvalidContact_ThrowsException() {
    JTextField contact = new JTextField("12345678901234");
    testCustomerAdder.setTxtcontact(contact);

    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
  }

//  @Test
//  public void testAllValid_NoExceptionThrown() throws Exception {
//    assertThrows(Exception.class, () -> testCustomerAdder.jButton2ActionPerformed(evt));
//  }
}
