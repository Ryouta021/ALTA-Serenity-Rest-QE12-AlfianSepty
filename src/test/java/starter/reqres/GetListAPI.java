package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetListAPI {
    public static String GET_LIST = Constants.BASE_URL+"/api/unknown?page={page}";

    @Step("Get list resource")
    public void getListResource(Object page){
        SerenityRest.given()
                .pathParam("page",page);
    }
}
