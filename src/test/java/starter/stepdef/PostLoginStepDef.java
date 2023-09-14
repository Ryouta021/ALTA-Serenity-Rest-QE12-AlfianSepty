package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("login with valid json {string}")
    public void loginWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postLogin(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(reqresAPI.POST_LOGIN);
    }

    @Given("login with invalid json {string}")
    public void loginWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        reqresAPI.postLogin(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
}
