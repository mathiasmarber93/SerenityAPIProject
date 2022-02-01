package rough;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class FirstTest {



    @Title("Sending GET Request Test")
    @Test
    public void testGetRequest(){
        Response response = SerenityRest.given().when().get("4");
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("firstName", Matchers.equalTo("Chris"));
    }

    @Title("Sending POST Request Test")
    @Test
    public void testPostRequest(){

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email","dummy1@user.com");
        map.put("firstName","Dummy1");
        map.put("lastName","User1");

        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(map).log().all().post();
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }

    @Title("Sending DELETE Request Test")
    @Test
    public void testDeleteRequest(){
        Response response = SerenityRest.given().when().delete("11");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        response.then().statusCode(200);
    }


}
