package InternationalAirlines.src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class CustomerSearchTest {
    private static CustomerSearch testCustomerSearch;
    private static ActionEvent evt;

    @BeforeEach
    public void initializeVariables() {
        testCustomerSearch = new CustomerSearch();
        evt = new ActionEvent(testCustomerSearch, 1, "");

        //set valid input
        JTextField firstName = new JTextField("Ben");
        JTextField lastName = new JTextField("Deleuze");
        JTextField nic = new JTextField("95493764");
        JTextField passport = new JTextField("9549376477");
        JTextField address = new JTextField("1 Liberty St");

        testCustomerSearch.setTxtfirstName(firstName);
        testCustomerSearch.setTxtlastName(lastName);
        testCustomerSearch.setTxtNic(nic);
        testCustomerSearch.setTxtPassport(passport);
        testCustomerSearch.setTxtAddress(address);

    }

    @Test
    public void testInvalidFirstName_ThrowsException() {
        JTextField firstName = new JTextField("8088");
        testCustomerSearch.setTxtfirstName(firstName);

        assertThrows(Exception.class, () -> testCustomerSearch.updateButtonClick(evt));
    }

    @Test
    public void testInvalidLastName_ThrowsException() {
        JTextField lastName = new JTextField("1234");
        testCustomerSearch.setTxtfirstName(lastName);

        assertThrows(Exception.class, () -> testCustomerSearch.browseButtonClick(evt));
    }

    @Test
    public void testInvalidNICName_ThrowsException() {
        JTextField nic = new JTextField("arroz con habichuelas");
        testCustomerSearch.setTxtfirstName(nic);

        assertThrows(Exception.class, () -> testCustomerSearch.updateButtonClick(evt));
    }

    @Test
    public void testInvalidPassport_ThrowsException() {
        JTextField passport = new JTextField("123SUCK");
        testCustomerSearch.setTxtfirstName(passport);

        assertThrows(Exception.class, () -> testCustomerSearch.browseButtonClick(evt));
    }

    @Test
    public void testInvalidAddress_ThrowsException() {
        JTextField address = new JTextField("123SUCK");
        testCustomerSearch.setTxtfirstName(address);

        assertThrows(Exception.class, () -> testCustomerSearch.browseButtonClick(evt));
    }
}
