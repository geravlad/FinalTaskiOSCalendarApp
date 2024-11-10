package utils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class RestAssuredUtility extends ConfigReader{

    private final RequestSpecification request = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Content-Type", "application/json");

    public String getActivityValue(String path) {
        JsonPath response = request.get(getProperty("bored.api.activity.endpoint"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();

        GlobalVariables.response = response.prettify();
        System.out.println(GlobalVariables.response);
        return response.get(path).toString();
    }

}
