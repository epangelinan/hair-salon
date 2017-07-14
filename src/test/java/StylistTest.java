import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class StylistTest {

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
  public void Stylist_instantiatesCorrectly_true() {
    Stylist myStylist = new Stylist("Stylist A");
    assertEquals(true, myStylist instanceof Stylist);
  }

  @Test
  public void getName_returnsName_StylistA() {
    Stylist myStylist = new Stylist("Stylist A");
    assertEquals("Stylist A", myStylist.getName());
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist(Stylist);
    firstStylist.save();
    Stylist secondStylist = new Stylist("Stylist B");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void clear_emptiesAllStylistsFromList_0() {
    Stylist firstStylist = new Stylist("Stylist A");
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void getId_stylistsInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Stylist A");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Stylist A");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Stylist B");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  //make sure a Stylist instantiates with an empty client list:
  @Test
  public void getClients_initiallyReturnsEmptyList_ArrayList() {
    Stylist testStylist = new Stylist("Stylist A");
    assertEquals(0, testStylist.getClients().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Stylist A");
    Stylist secondStylist = new Stylist("Stylist A");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist testStylist = new Stylist("Stylist A");
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist testStylist = new Stylist("Stylist A");
    testStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(testStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Stylist A");
    myStylist.save();
    Client firstClient = new Client("Client A", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Client B", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }
}
