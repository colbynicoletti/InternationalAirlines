import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class FlightAdderTest {

    private static FlightAdder testFlightAdder;
    private static ActionEvent evt;


    @BeforeEach
    public void initializeVariables() {
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
        JTextField flightName = new JTextField("American");
        testFlightAdder.setTxtflightname(flightName);

        assertThrows(Exception.class, () -> testFlightAdder.submitFlightButtonClick(evt));

    }

    @Test
    public void testInvalidFlightCharge_ThrowsException() {
        JTextField flightCharge = new JTextField("agfhthr");
        testFlightAdder.setTxtflightname(flightCharge);

        assertThrows(Exception.class, () -> testFlightAdder.submitFlightButtonClick(evt));
    }

    @Test
    public void testInvalidSource_ThrowsException() {
        JTextField source = new JTextField("Canada");
        testFlightAdder.setTxtflightname(source);

        assertThrows(Exception.class, () -> testFlightAdder.submitFlightButtonClick(evt));
    }

    @Test
    public void testInvalidDepart_ThrowsException() {
        JTextField depart = new JTextField("China");
        testFlightAdder.setTxtflightname(depart);

        assertThrows(Exception.class, () -> testFlightAdder.submitFlightButtonClick(evt));
    }

    @Test
    public void testInvalidDTime_ThrowsException() {
        JTextField dTime = new JTextField("");
        testFlightAdder.setTxtflightname(dTime);

        assertThrows(Exception.class, () -> testFlightAdder.submitFlightButtonClick(evt));
    }

    @Test
    public void testInvalidArrTime_ThrowsException() {
        JTextField arrTime = new JTextField("14:00");
        testFlightAdder.setTxtflightname(arrTime);

        assertThrows(Exception.class, () -> testFlightAdder.submitFlightButtonClick(evt));
    }
}