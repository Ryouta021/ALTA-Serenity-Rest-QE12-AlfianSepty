package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetSingleUserAPI;
import starter.reqres.ReqresAPI;

public class GetSingleUserStepDef {
    @Steps
    GetSingleUserAPI getSingleUser;
    @Given("Single user with valid parameter {int}")
    public void singleUserWithValidParameter(int page ) {
        getSingleUser.getSingleUser(page);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetSingleUserAPI.GET_SINGLE_USER);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Single user with exceed parameter {int}")
    public void singleUserWithInvalidParameter(int page) {
        getSingleUser.getSingleUser(page);
    }
    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
