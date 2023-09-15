package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PutUpdateAPI {
    public static String PUT_UPDATE = Constants.BASE_URL+"/api/users/{id}";

    @Step("Put update user")
    public void putUpdateUser(File json,Object id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
