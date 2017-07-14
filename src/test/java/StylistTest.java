import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist myStylist = new Stylist("Stylist A");
    assertEquals(true, myStylist instanceof Stylist);
  }

  @Test
  public void getName_returnsName_StylistA() {
    Stylist myStylist = new Stylist("Stylist A");
    assertEquals("Stylist A", myStylist.getName());
  }
}
