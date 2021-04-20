package InternationalAirlines.src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
        private static Login LoginTest;
        private static ActionEvent evt;

        @BeforeEach
        public void initializeVariables() {
            LoginTest = new Login();
            evt = new ActionEvent(LoginTest, 1, "");

            //set valid input
            JTextField username = new JTextField("Ben");
            JPasswordField password = new JPasswordField("Deleuze");

            LoginTest.setTextUser(username);
            LoginTest.setTextPassword(password);

        }

        @Test
        public void testInvalidUser_ThrowsException() {
            JTextField username = new JTextField("123");
            LoginTest.setTextUser(username);

            assertThrows(Exception.class, () -> LoginTest.jButton1ActionPerformed(evt));
        }

        @Test
        public void testInvalidPass_ThrowsException() {
            JPasswordField password = new JPasswordField("1234");
            LoginTest.setTextPassword(password);

            assertThrows(Exception.class, () -> LoginTest.jButton1ActionPerformed(evt));
        }

}