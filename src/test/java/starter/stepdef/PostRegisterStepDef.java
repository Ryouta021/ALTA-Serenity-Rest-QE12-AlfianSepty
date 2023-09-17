package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostRegisterAPI;

import starter.utils.Constants;

import java.io.File;

public class PostRegisterStepDef {

    @Steps
    PostRegisterAPI postRegisterAPI;
    @Given("Register with valid json {string}")
    public void registerWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postRegisterAPI.postRegister(json);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(postRegisterAPI.POST_REGISTER);
    }

    @Given("Register with invalid json {string}")
    public void registerWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postRegisterAPI.postRegister(json);
    }

    @And("Validate Post register user JSON Schema {string}")
    public void validatePostRegisterUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
