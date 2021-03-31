package InternationalAirlines.src;

import com.toedter.calendar.JDateChooser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FlightAdderTest {

    private static FlightAdder testFlightAdder;
    private static ActionEvent evt;

    @BeforeAll
    public static void initializeVariables() {
        testFlightAdder = new FlightAdder();
        evt = new ActionEvent(testFlightAdder, 1, "");

        //set valid input
        JTextField flightName = new JTextField("Ben");
        JTextField flightCharge = new JTextField("Deleuze");
        JComboBox Source = new JComboBox();
        JComboBox Depart = new JComboBox();
        JTextField dTime = new JTextField("1 Liberty St");
        JTextField arrTime = new JTextField("9549376477");
        testFlightAdder.setTxtflightname(flightName);
        testFlightAdder.setTxtflightcharge(flightCharge);
        testFlightAdder.setTextSource(Source);
        testFlightAdder.setTxtDepart(Depart);
        testFlightAdder.setTxtdtime(dTime);
        testFlightAdder.setTxtarrtime(arrTime);
    }

    @Test
    public void testInvalidFirstName_ThrowsException() {
        JTextField flightName = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(flightName);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }
}