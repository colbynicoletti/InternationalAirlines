import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class UserCreatorTest {

  private UserCreator testUserCreator = new UserCreator();
  private String firstName;
  private String lastName;
  private String username;
  private String password;

  @BeforeEach
  public void setValidInput() {
    firstName = "Ben";
    lastName = "Deleuze";
    username = "Ben.Deleuze";
    password = "Examp1eP@ssword";
  }

  @Test
  public void testInvalidFirstName_ThrowsException() {
    firstName = "12LK";
    assertThrows(Exception.class,
        () -> testUserCreator.testInputForNewUser(firstName, lastName, username, password));
  }

  @Test
  public void testInvalidLastName_ThrowsException() {
    lastName = "Kl3M 4";
    assertThrows(Exception.class,
        () -> testUserCreator.testInputForNewUser(firstName, lastName, username, password));
  }

  @Test
  public void testInvalidUsername_ThrowsException() {
    username = "NOt !rtgf.";
    assertThrows(Exception.class,
        () -> testUserCreator.testInputForNewUser(firstName, lastName, username, password));
  }

  @Test
  public void testInvalidPassword_ThrowsException() {
    password = "password";
    assertThrows(Exception.class,
        () -> testUserCreator.testInputForNewUser(firstName, lastName, username, password));
  }

  @Test
  public void testAllValid_NoExceptionThrown() {
    assertDoesNotThrow(
        () -> testUserCreator.testInputForNewUser(firstName, lastName, username, password));
  }
}