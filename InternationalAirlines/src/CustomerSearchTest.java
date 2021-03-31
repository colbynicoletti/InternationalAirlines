package InternationalAirlines.src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class CustomerSearchTest {
    private static CustomerSearch testCustomerSearch;
    private static ActionEvent evt;

    @BeforeAll
    public static void initializeVariables() {
        testCustomerSearch = new CustomerSearch();
        evt = new ActionEvent(testCustomerSearch, 1, "");

        //set valid input
        JTextField firstName = new JTextField("Ben");
        JTextField lastName = new JTextField("Deleuze");
        JTextField nic = new JTextField("1 Liberty St");
        JTextField passport = new JTextField("9549376477");
        JTextField address = new JTextField("9549376477");

        testCustomerSearch.setTxtfirstName(firstName);
        testCustomerSearch.setTxtlastName(lastName);
        testCustomerSearch.setTxtNic(nic);
        testCustomerSearch.setTxtPassport(passport);
        testCustomerSearch.setTxtAddress(address);

    }

    @Test
    public void testInvalidFirstName_ThrowsException() {
        JTextField firstName = new JTextField("123SUCK");
        testCustomerSearch.setTxtfirstName(firstName);

        assertThrows(Exception.class, () -> testCustomerSearch.jButton1ActionPerformed(evt));
    }
}
