package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetListAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetListResourceStepDef {
    @Steps
    GetListAPI getListAPI;

    @Given("Get list resouces with valid parameter page {int}")
    public void getListResoucesWithValidParameterPage(int page) {
        getListAPI.getListResource(page);

    }

    @When("Send Request get list resources")
    public void sendRequestGetListResources() {
        SerenityRest.when().get(getListAPI.GET_LIST);
    }

    @And("Response body page should be {}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));

    }

    @And("Validate get list user JSON Schema {string}")
    public void validateGetListUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get list resouces with valid parameter page {string}")
    public void getListResoucesWithValidParameterPage(String page) {
        getListAPI.getListResource(page);
    }

}
