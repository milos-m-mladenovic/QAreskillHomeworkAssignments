package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.PublicApiEndpoints;
import data.models.common.CrocodileResponse;

public class PublicAPI {

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(PublicApiEndpoints.CROCODILES), CrocodileResponse[].class);
    }

    public static CrocodileResponse getSinglePublicCrocodile(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(PublicApiEndpoints.SINGLE_CROCODILE(id)), CrocodileResponse.class);
    }
}
