import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Client A", 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void getName_instantiatesWithName_String() {
    Client myClient = new Client("Client A", 1);
    assertEquals("Client A", myClient.getName());
  }

  @Test
  public void getStylistId_instantiatesWithStylistId_1() {
    Client myClient = new Client("Client A", 1);
    assertEquals(1, myClient.getStylistId());
  }

}
