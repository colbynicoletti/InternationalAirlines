package InternationalAirlines.src;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.Before;
import org.junit.Test;

public class UserCreatorTest {

  UserCreator userCreator;
  ActionEvent evt;

  @Before
  public void initializeVariables() {
    userCreator = new UserCreator();
    evt = new ActionEvent(this, 1, "");

    //set valid input
    JTextField firstName = new JTextField("Ben");
    JTextField lastName = new JTextField("Deleuze");
    JTextField username = new JTextField("Ben.Deleuze");
    JPasswordField password = new JPasswordField("Examp1eP@ssword");
    userCreator.setTextFirstName(firstName);
    userCreator.setTextLastName(lastName);
    userCreator.setTextUsername(username);
    userCreator.setTextPassword(password);
  }

  @Test(expected = Exception.class)
  public void testInvalidFirstName_ThrowsException() throws Exception {
    JTextField firstName = new JTextField("12LK");
    userCreator.setTextFirstName(firstName);

    userCreator.jButton1ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void testInvalidLastName_ThrowsException() throws Exception {
    JTextField lastName = new JTextField("Kl3M 4");
    userCreator.setTextLastName(lastName);

    userCreator.jButton1ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void testInvalidUsername_ThrowsException() throws Exception {
    JTextField username = new JTextField("NOt !rtgf.");
    userCreator.setTextUsername(username);

    userCreator.jButton1ActionPerformed(evt);
  }

  @Test(expected = Exception.class)
  public void testInvalidPassword_ThrowsException() throws Exception {
    JPasswordField password = new JPasswordField("password");
    userCreator.setTextPassword(password);

    userCreator.jButton1ActionPerformed(evt);
  }

//  @Test
//  public void TestAllValid_NoExceptionThrown() throws Exception {
//    JTextField firstName = new JTextField("Ben");
//    JTextField lastName = new JTextField("Deleuze");
//    JTextField username = new JTextField("Ben.Deleuze");
//    JPasswordField password = new JPasswordField("Examp1eP@ssword");
//    userCreator.setTextFirstName(firstName);
//    userCreator.setTextLastName(lastName);
//    userCreator.setTextUsername(username);
//    userCreator.setTextPassword(password);
//
//    userCreator.jButton1ActionPerformed(evt);
//  }
}
