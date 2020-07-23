import config.ConfigFileObject;
import helpers.APIHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SampleTest {

    private static String basicAuth = "";
    private static ConfigFileObject configObject;

    @BeforeClass
    public void setUp() {
        System.out.println("Environment chosen : " + System.getProperty("environment"));
        String propertyFile = System.getProperty("environment").toLowerCase() + "-config.properties";
        System.out.println("Property file loaded: " + propertyFile);

        configObject = new ConfigFileObject(propertyFile);
        RestAssured.baseURI = configObject.baseURL;
    }

    @Test
    public  void getUsers() {
        Response response= APIHelper.getUsers();
       // System.out.println("Responses"+response.prettyPrint());
       // Assert.assertEquals(response.getStatusCode(),200);
        }

    @AfterSuite
    public void tearDown() {
        System.out.println("Test execution Completed");
    }
}