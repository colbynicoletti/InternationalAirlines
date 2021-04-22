
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GUITest {

  private FrameFixture window;
  Login loginFrame;
  Main mainFrame;

  @BeforeClass
  static void setUpOnce() {
    FailOnThreadViolationRepaintManager.install();
  }

  @BeforeEach
  public void setUp() {
    loginFrame = GuiActionRunner.execute(Login::new);
    mainFrame = GuiActionRunner.execute(Main::new);
  }

  @AfterEach
  protected void tearDown () {
    window. cleanUp () ;
  }

  @Test
  public void loginTest() {
    window = new FrameFixture(loginFrame);
    window.show();
    window.textBox("UsernameTF").enterText("Ben.Deleuze");
    window.textBox("PasswordTF").enterText("Examp1eP@ssword");
    window.button("SubmitButton").click();
  }

  @Test
  public void customerSearchTest() {
    window = new FrameFixture(mainFrame);
    window.show();
    window.menuItem("CustomerMenu").click();
    window.menuItem("CustomerSearch").click();
    window.textBox("CustomerIDTF").enterText("cs001");
    window.button("FindButton").click();
  }

  @Test
  public void customerAddTest() {
    window = new FrameFixture(mainFrame);
    window.show();
    window.menuItem("CustomerMenu").click();
    window.menuItem("CustomerAdd").click();
    window.textBox("Firstname").enterText("FirstnameTest");
    window.textBox("Lastname").enterText("LastnameTest");
    window.textBox("Nic").enterText("12345678");
    window.textBox("Passport").enterText("A2096457");
    window.textBox("Address").enterText("1 Liberty St");
    window.radioButton("Male").click();
    window.textBox("Contact").enterText("9549376478");
    window.button("Cancel").click();
  }

}
