//package api.soap;
//
//import org.apache.commons.compress.utils.IOUtils;
//import org.testng.annotations.Test;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
//import static io.restassured.RestAssured.given;
//
//public class calculatorAPI {
//    @Test
//    public void add() throws FileNotFoundException {
//        InputStream inputStream = new FileInputStream(getClass().getClassLoader().getResource("add.xml").getFile());
//        String xmlBody = IOUtils.toString(inputStream);
//        given()
//                .contentType("text/xml")
//                .body(xmlBody)
//                .when()
//                .post("http://www.dneonline.com/calculator.asmx")
//                .then()
//                .log().all();
//
//
//    }
//}
