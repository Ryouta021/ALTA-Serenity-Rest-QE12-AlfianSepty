package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostRegisterAPI {

    public static String POST_REGISTER = Constants.BASE_URL+"/api/register";


    @Step("Post register")
    public void postRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
