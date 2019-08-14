import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
//import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

public class rest1 {

        @Test
        public  void test1 () {


                RestAssured.baseURI = "https://maps.googleapis.com";
                given().
                        param("location", "-33.8670522,151.1957362").
                        param("radius", "500").
                        param("key", "AIzaSyBC2ckTYboBGzRNGA87Bji1JUTdPFrpcLE").
                        when().get("/maps/api/place/nearbysearch/json").
                        then().
                        assertThat().statusCode(200);
        }


}
