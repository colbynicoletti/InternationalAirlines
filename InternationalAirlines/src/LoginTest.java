package InternationalAirlines.src;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LoginTest {

  private static Login LoginTest;
  private static ActionEvent evt;
  JTextField usernameTF;
  String username;
  String password;
  JPasswordField passwordPF;

  @BeforeEach
  public void initializeVariables() {
    LoginTest = new Login();
    evt = new ActionEvent(LoginTest, 1, "");

    //set valid input
    username = "Ben.Deleuze";
    usernameTF = new JTextField(username);
    password = "Examp1eP@ssword";
    passwordPF = new JPasswordField(password);

    LoginTest.setTextUser(usernameTF);
    LoginTest.setTextPassword(passwordPF);

  }

  @Test
  public void testDBConnection_UsingMock() throws Exception {
    Login mockLogin = Mockito.spy(new Login());
    mockLogin.setTextUser(usernameTF);
    mockLogin.setTextPassword(passwordPF);
    mockLogin.jButton1ActionPerformed(evt);
    verify(mockLogin, times(1)).searchForUser(username, password);

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