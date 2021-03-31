package InternationalAirlines.src;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.*;

class UserCreatorTest {

  private static UserCreator testUserCreator;
  private static ActionEvent evt;

  @BeforeAll
  public static void initializeVariables() {
    testUserCreator = new UserCreator();
    evt = new ActionEvent(testUserCreator, 1, "");

    //set valid input
    JTextField firstName = new JTextField("Ben");
    JTextField lastName = new JTextField("Deleuze");
    JTextField username = new JTextField("Ben.Deleuze");
    JPasswordField password = new JPasswordField("Examp1eP@ssword");
    testUserCreator.setTextFirstName(firstName);
    testUserCreator.setTextLastName(lastName);
    testUserCreator.setTextUsername(username);
    testUserCreator.setTextPassword(password);
  }

  @Test
  public void testInvalidFirstName_ThrowsException() {
    JTextField firstName = new JTextField("12LK");
    testUserCreator.setTextFirstName(firstName);

    assertThrows(Exception.class, () -> testUserCreator.jButton1ActionPerformed(evt));
  }

  @Test
  public void testInvalidLastName_ThrowsException() {
    JTextField lastName = new JTextField("Kl3M 4");
    testUserCreator.setTextLastName(lastName);

    assertThrows(Exception.class, () -> testUserCreator.jButton1ActionPerformed(evt));
  }

  @Test
  public void testInvalidUsername_ThrowsException() {
    JTextField username = new JTextField("NOt !rtgf.");
    testUserCreator.setTextUsername(username);

    assertThrows(Exception.class, () -> testUserCreator.jButton1ActionPerformed(evt));
  }

  @Test
  public void testInvalidPassword_ThrowsException() {
    JPasswordField password = new JPasswordField("password");
    testUserCreator.setTextPassword(password);

    assertThrows(Exception.class, () -> testUserCreator.jButton1ActionPerformed(evt));
  }
//  @Test
//  public void testAllValid_NoExceptionThrown() {
//    assertDoesNotThrow(() -> userCreator.jButton1ActionPerformed(evt));
//  }
}