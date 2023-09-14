package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_USER_LIST = Constants.BASE_URL+"/api/users?page={page}";

    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";

    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";

<<<<<<< Updated upstream
=======
    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{page}";
    public static String POST_LOGIN = Constants.BASE_URL+"/api/login";
    public static String POST_REGISTER = Constants.BASE_URL+"/api/register";

>>>>>>> Stashed changes
    @Step("Get List User")
    public void getListUser(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(File json,int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete a user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
<<<<<<< Updated upstream
=======
    @Step("Get single user")
    public void getSingleUser(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login")
    public void postRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
>>>>>>> Stashed changes
}


