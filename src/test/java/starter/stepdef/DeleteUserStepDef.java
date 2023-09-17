package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.DeleteUserAPI;

public class DeleteUserStepDef {

    @Steps
    DeleteUserAPI deleteUserAPI;
    @Given("Delete a user with valid user id {}")
    public void deleteAUserWithValidUserId(int id) {
        deleteUserAPI.deleteUserAPI(id);
    }

    @When("send Request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(deleteUserAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
