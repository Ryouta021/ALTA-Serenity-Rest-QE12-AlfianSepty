package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostLoginAPI {

    public static String POST_LOGIN = Constants.BASE_URL+"/api/login";

    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
