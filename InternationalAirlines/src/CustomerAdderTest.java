package InternationalAirlines.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import org.junit.Before;
import org.junit.Test;
// Testing
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
        JTextField firstName  = new JTextField("123SUCK");
        testCustomerAdder.setTxtfirstname(firstName);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }

    @Test(expected = Exception.class)
    public void TestInvalidLastName_ThrowsException() throws Exception {
        JTextField lastName = new JTextField("!@#MY");
        testCustomerAdder.setTxtlastname(lastName);

        testCustomerAdder.jButton2ActionPerformed(evt);
    }
}
