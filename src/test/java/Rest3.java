import Files.Resources;
import com.jayway.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Files.payLoad;
import static io.restassured.RestAssured.given;

public class Rest3 {
    Properties prop = new Properties();
    @BeforeTest
    public void getData() throws IOException{

        FileInputStream fis = new FileInputStream("C:\\Users\\ieroglu\\IdeaProjects\\RestAssured\\src\\test\\java\\Files\\Env.properties");
        prop.load(fis);


    }

    @Test
    public void AddDeletePlace(){



        RestAssured.baseURI = prop.getProperty("HOST");
      Response res =  given().
                queryParam("key", prop.getProperty("KEY")).
                body(payLoad.getPostData()).
                when().post(Resources.placePostData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();

        //extract the respond
        String responseString = res.asString();
        System.out.println( responseString  );

        // get the place id. you have to convert from string to json.
        //convert response from raw data to string then convert from string to json format
        JsonPath js = new JsonPath(responseString);
        String placeId = js.get("place_id");

        System.out.println(  placeId  );


        //task 3 place the id in delete request
        given().queryParam("key", "qaclick123").
                body("{\"place_id\": \"placeId\"}").
                when().
                post("/maps/api/place/add/json").then().assertThat().statusCode(200).and().contentType(ContentType.JSON);




    }
}
