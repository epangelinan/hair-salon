import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

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

  @Test
  public void getId_clientsInstantiateWithAnID_1() {
    Client myClient = new Client("Client A", 1);
    myClient.save();
    assertTrue(myClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Client A", 1);
    firstClient.save();
    Client secondClient = new Client("Client B", 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Client firstClient = new Client("Client A", 1);
    Client secondClient = new Client("Client A", 1);
    //System.out.println("first song: " + firstSong.getDecadeId());
    //System.out.println("second song: " + secondSong.getDecadeId());
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfNameAretheSame() {
    Client myClient = new Client("Client A", 1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Client A", 1);
    firstClient.save();
    Client secondClient = new Client("Client B", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Client A", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist("Stylist A");
    myStylist.save();
    Client myClient = new Client("Client A", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }
}
