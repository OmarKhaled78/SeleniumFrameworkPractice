package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredcookies;
    private String accessToken;
    private String userID;
    private String firstName;

    public String getFirstName() {
        return firstName;
    }


    public String getUserID() {
        return this.userID;
    }



    public String getAccessToken() {
        return this.accessToken;
    }

    public List<Cookie> getRestAssuredcookies() {
        return this.restAssuredcookies;
    }


    public void register(){
        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                    .baseUri("https://qacart-todo.herokuapp.com")
                    .header("Content-Type" , "application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                        .extract().response();
        if(response.statusCode() != 201){
            throw new RuntimeException("Something went wrong with our request");

        }
         restAssuredcookies = response.detailedCookies().asList();
         accessToken = response.path("access_token");
         userID = response.path("userID");
         firstName = response.path("firstName");


    }
}
