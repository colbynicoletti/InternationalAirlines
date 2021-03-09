package InternationalAirlines.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
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
        testCustomerAdder.setTxtlastname(nic);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }

    @Test(expected = Exception.class)
    public void TestInvalidPassport_ThrowsException() throws Exception {
        JTextField passport = new JTextField("APR1234");
        testCustomerAdder.setTxtlastname(passport);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }

    @Test(expected = Exception.class)
    public void TestInvalidAddress_ThrowsException() throws Exception {
        JTextField address = new JTextField("8008 san carlos");
        testCustomerAdder.setTxtlastname(address);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }

    @Test(expected = Exception.class)
    public void TestInvalidDate_ThrowsException() throws Exception {
        JTextField date = new JTextField("03/08/2021");
        testCustomerAdder.setTxtlastname(date);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }

    @Test(expected = Exception.class)
    public void TestInvalidContact_ThrowsException() throws Exception {
        JTextField contact = new JTextField("5555555555");
        testCustomerAdder.setTxtlastname(contact);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }
}
