package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PutUpdateAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PutUpdateUserStepDef {

    @Steps
    PutUpdateAPI putUpdateAPI;

    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String jsonFile , int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        putUpdateAPI.putUpdateUser(json,id);
    }

    @When("Send Request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(putUpdateAPI.PUT_UPDATE);
    }


    @And("Response body name should be {string} and job was {string}")
    public void responseBodyNameShouldBeAndJobWas(String name, String job) {
        SerenityRest.and()
               .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate update user JSON schema {string}")
    public void validateUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
              .assertThat()
               .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Update user with invalid json {string} and invalid user {string}")
    public void updateUserWithInvalidJsonAndInvalidUser(String jsonFile, String id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        putUpdateAPI.putUpdateUser(json,id);
    }
}
