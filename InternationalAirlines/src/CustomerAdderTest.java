package InternationalAirlines.src;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.Before;
import org.junit.Test;

public class CustomerAdderTest {

  CustomerAdder testCustomerAdder;
  ActionEvent evt;

  @Before
  public void initializeVariables() {
    testCustomerAdder = new CustomerAdder();
    evt = new ActionEvent(this, 1, "");

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

  @Test(expected = Exception.class)
  public void testInvalidFirstName_ThrowsException() throws Exception {
    JTextField firstName = new JTextField("123SUCK");
    testCustomerAdder.setTxtfirstname(firstName);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void TestInvalidLastName_ThrowsException() throws Exception {
    JTextField lastName = new JTextField("!@#MY");
    testCustomerAdder.setTxtlastname(lastName);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void TestInvalidNic_ThrowsException() throws Exception {
    JTextField nic = new JTextField("(*)(*)");
    testCustomerAdder.setTxtnic(nic);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void TestInvalidPassport_ThrowsException() throws Exception {
    JTextField passport = new JTextField("APR1234");
    testCustomerAdder.setTxtpassport(passport);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void TestInvalidAddress_ThrowsException() throws Exception {
    JTextArea address = new JTextArea("8008 san carlos");
    testCustomerAdder.setTxtaddress(address);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void TestInvalidDate_ThrowsException() throws Exception {
    String strDate = "";
    Date dDate = new Date();
    JDateChooser date = new JDateChooser(dDate, strDate);
    testCustomerAdder.setTxtdob(date);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void TestInvalidContact_ThrowsException() throws Exception {
    JTextField contact = new JTextField("12345678901234");
    testCustomerAdder.setTxtcontact(contact);

    testCustomerAdder.jButton2ActionPerformed(evt);
  }

//  @Test
//  public void TestAllValid_NoExceptionThrown() throws Exception {
//    JTextField firstName = new JTextField("Ben");
//    JTextField lastName = new JTextField("Deleuze");
//    JTextField nic = new JTextField("12345678");
//    JTextField passport = new JTextField("A2096457");
//    JTextArea address = new JTextArea("1 Liberty St");
//    Date dDate = new Date(System.currentTimeMillis());
//    JDateChooser date = new JDateChooser(dDate);
//    JTextField contact = new JTextField("9549376477");
//    testCustomerAdder.setTxtfirstname(firstName);
//    testCustomerAdder.setTxtlastname(lastName);
//    testCustomerAdder.setTxtnic(nic);
//    testCustomerAdder.setTxtpassport(passport);
//    testCustomerAdder.setTxtaddress(address);
//    testCustomerAdder.setTxtdob(date);
//    testCustomerAdder.setTxtcontact(contact);
//
//    testCustomerAdder.jButton2ActionPerformed(evt);
//  }
}
