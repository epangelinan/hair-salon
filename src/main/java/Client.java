import java.util.ArrayList;
import java.util.List;

public class Client {
  private String name;
  private int stylistID;

  public Client(String name, int stylistID) {
    this.name = name;
    this.stylistID = stylistID;
  }

  public String getName() {
    return name;
  }

  public int getStylistId() {
    return stylistID;
  }
}
