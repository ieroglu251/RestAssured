package Files;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

    public static XmlPath rawToXML(Response r)
    {


        String respon=r.asString();
        XmlPath x=new XmlPath(respon);
        return x;

    }

    public static io.restassured.path.json.JsonPath rawToJson(Response r)
    {
        String respon=r.asString();
        JsonPath x=new JsonPath(respon);
        return x;
    }
}
