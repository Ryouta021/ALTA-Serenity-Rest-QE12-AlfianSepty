//package starter.stepdef;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.module.jsv.JsonSchemaValidator;
//import net.serenitybdd.rest.SerenityRest;
//import net.thucydides.core.annotations.Steps;
//import starter.reqres.ReqresAPI;
//import starter.reqres.ReqresResponses;
//import starter.utils.Constants;
//
//import java.io.File;
//import static org.hamcrest.Matchers.equalTo;
//
//public class ReqresStepDef {
//
////LIST USER
//    @Steps
//    ReqresAPI reqresAPI;
//    @Given("Get list user with valid parameter page {int}")
//    public void getListUserWithValidParameterPage(int page) {
//        reqresAPI.getListUser(page);
//    }
//
//    @When("Send Request get list users")
//    public void sendRequestGetListUsers() {
//        SerenityRest.when().get(ReqresAPI.GET_USER_LIST);
//    }
//
//    @Then("Status code should be {int} OK")
//    public void statusCodeShouldBeOK(int ok) {
//        SerenityRest.then().statusCode(ok);
//    }
//    @And("Response body page should be {int}")
//    public void responseBodyPageShouldBe(int page) {
//    SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
//    }
//    @And("Validate get list user JSON Schema {string}")
//    public void validateGetListUserJSONSchema(String jsonFile) {
//        File json = new File(Constants.JSON_SCHEMA+jsonFile);
//        SerenityRest.and()
//                .assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(json));
//    }
////NEW USER
//    @Given("Create New user with valid json {string}")
//    public void createNewUserWithValidJson(String jsonFile) {
//        File json = new File(Constants.REQ_BODY+jsonFile);
//        reqresAPI.postCreateNewUser(json);
//    }
//
//    @When("Send request post create new user")
//    public void sendRequestPostCreateNewUser() {
//        SerenityRest.when().post(reqresAPI.POST_CREATE_USER);
//    }
//
//    @Then("Status code should be {int} Created")
//    public void statusCodeShouldBeCreated(int created) {
//        SerenityRest.then().statusCode(created);
//    }
//
//    @And("Response body name should be {string} and job was {string}")
//    public void responseBodyNameShouldBeAndJobWas(String name, String job) {
//        SerenityRest.and()
//                .body(ReqresResponses.NAME,equalTo(name))
//                .body(ReqresResponses.JOB,equalTo(job));
//    }
//    @And("Validate create a new user JSON schema {string}")
//    public void validateCreateANewUserJSONSchema(String jsonFile) {
//        File json = new File(Constants.JSON_SCHEMA+jsonFile);
//        reqresAPI.postCreateNewUser(json);
//    }
////UPDATE USER
//    @Given("Update user with valid json {string} and user id {}")
//    public void updateUserWithValidJsonAndUserId(String jsonFile , int id) {
//        File json = new File(Constants.REQ_BODY+jsonFile);
//        reqresAPI.putUpdateUser(json,id);
//    }
//
//    @When("Send Request put update user")
//    public void sendRequestPutUpdateUser() {
//        SerenityRest.when().put(reqresAPI.PUT_UPDATE_USER);
//    }
//    @And("Validate update user JSON schema {string}")
//    public void validateUpdateUserJSONSchema(String jsonFile) {
//        File json = new File(Constants.JSON_SCHEMA+jsonFile);
//        SerenityRest.and()
//                .assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(json));
//    }
//
////DELETE
//    @Given("Delete a user with valid user id {}")
//    public void deleteAUserWithValidUserId(int id) {
//        reqresAPI.deleteUser(id);
//    }
//    @When("send Request delete user")
//    public void sendRequestDeleteUser() {
//        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
//    }
//    @Then("Status code should be {int} No Content")
//    public void statusCodeShouldBeNoContent(int noContent) {
//        SerenityRest.then().statusCode(noContent);
//    }
//
//
//}
