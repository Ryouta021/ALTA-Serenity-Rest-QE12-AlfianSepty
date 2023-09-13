package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUser(page);
    }

    @When("Send Request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_USER_LIST);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
//NEW USER
    @Given("Create New user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(reqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
//UPDATE USER
    @Given("Update user with valid json {string} and user id {}")
    public void updateUserWithValidJsonAndUserId(String jsonFile , int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.putUpdateUser(json,id);
    }

    @When("Send Request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(reqresAPI.PUT_UPDATE_USER);
    }
//DELETE
    @Given("Delete a user with valid user id {}")
    public void deleteAUserWithValidUserId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("send Request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
