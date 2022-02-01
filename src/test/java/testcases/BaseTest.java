package testcases;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost:9090";
        RestAssured.basePath="/api/users/";
    }



}
