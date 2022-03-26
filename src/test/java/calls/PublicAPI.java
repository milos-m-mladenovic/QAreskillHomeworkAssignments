package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.common.CrocodileResponse;

public class PublicAPI {

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), CrocodileResponse[].class);
    }

    public static CrocodileResponse getSinglePublicCrocodile(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/" + id + "/"), CrocodileResponse.class);
    }
}
