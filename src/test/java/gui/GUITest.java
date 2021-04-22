
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
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
  protected void tearDown() {
    window.cleanUp();
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
    window.button("Cancel").click();
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

  @Test
  public void bookTicketTest() {
    window = new FrameFixture(mainFrame);
    window.show();
    window.menuItem("TicketMenu").click();
    window.menuItem("BookTicket").click();
    window.comboBox("Source").selectItem(0);
    window.comboBox("Depart").selectItem(2);
    window.button("SearchFlight").click();
    window.table("Table").selectRows(0);
    window.textBox("CustomerID").enterText("cs001");
    window.button("SearchCustomer").click();
    window.comboBox("Class").selectItem(0);
    window.spinner("Seats").increment();
    window.button("Cancel").click();
  }

  @Test
  public void ticketReportTest() {
    window = new FrameFixture(mainFrame);
    window.show();
    window.menuItem("TicketMenu").click();
    window.menuItem("TicketReport").click();
    window.button("Cancel").click();
  }

  @Test
  public void addFlightTest() {
    window = new FrameFixture(mainFrame);
    window.show();
    window.menuItem("FlightMenu").click();
    window.menuItem("AddFlight").click();
    window.textBox("FlightName").enterText("TestFlight");
    window.comboBox("Source").selectItem(0);
    window.comboBox("Depart").selectItem(2);
    window.textBox("DepTime").enterText("9:00");
    window.textBox("ArrTime").enterText("13:00");
    window.textBox("Charge").enterText("10000");
    window.button("Cancel").click();
  }

  @Test
  public void addUserTest() {
    window = new FrameFixture(mainFrame);
    window.show();
    window.menuItem("UserMenu").click();
    window.menuItem("UserCreation").click();
    window.textBox("Firstname").enterText("TestFirstname");
    window.textBox("Lastname").enterText("TestLastname");
    window.textBox("Username").enterText("TestUsername");
    window.textBox("Password").enterText("TestPa$$word");
    window.button("Cancel").click();
  }
}
