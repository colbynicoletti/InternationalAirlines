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

    @BeforeEach
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
    public void testInvalidFlightName_ThrowsException() {
        JTextField flightName = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(flightName);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }

    @Test
    public void testInvalidFlightCharge_ThrowsException() {
        JTextField flightCharge = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(flightCharge);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }

    @Test
    public void testInvalidSource_ThrowsException() {
        JTextField source = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(source);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }

    @Test
    public void testInvalidDepart_ThrowsException() {
        JTextField depart = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(depart);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }

    @Test
    public void testInvalidDTime_ThrowsException() {
        JTextField dTime = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(dTime);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }

    @Test
    public void testInvalidArrTime_ThrowsException() {
        JTextField arrTime = new JTextField("123SUCK");
        testFlightAdder.setTxtflightname(arrTime);

        assertThrows(Exception.class, () -> testFlightAdder.jButton1ActionPerformed(evt));
    }
}