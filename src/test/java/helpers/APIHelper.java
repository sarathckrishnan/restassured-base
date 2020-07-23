package helpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class APIHelper{

    public static Response getUsers(){
        RestAssured.basePath = "/api/users";

        return RestAssured.given()
                .queryParam("page","1")
                .log().uri()
                .header("Content-Type", "application/json; charset=utf-8")
                .accept("text/html")
                .when().get()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response();
    }
}