import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LoginIntegrationTest {

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
}
