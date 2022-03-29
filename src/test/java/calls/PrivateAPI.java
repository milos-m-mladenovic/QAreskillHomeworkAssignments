package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.PrivateApiEndpoints;
import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;

public class PrivateAPI {

    public static CrocodileResponse createNewCrocodile(String accessToken, CrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(PrivateApiEndpoints.CROCODILES, accessToken, createCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse getSinglePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(PrivateApiEndpoints.SINGLE_CROCODILE(id), accessToken), CrocodileResponse.class);
    }

    public static CrocodileResponse[] getAllPrivateCrocodiles(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(PrivateApiEndpoints.CROCODILES, accessToken), CrocodileResponse[].class);
    }

    public static CrocodileResponse putPrivateCrocodile(int id, String accessToken, CrocodileRequest putCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(PrivateApiEndpoints.SINGLE_CROCODILE(id), accessToken, putCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchPrivateCrocodile(int id, String accessToken, CrocodileRequest patchCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(PrivateApiEndpoints.SINGLE_CROCODILE(id), accessToken, patchCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse deletePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(PrivateApiEndpoints.SINGLE_CROCODILE(id), accessToken), CrocodileResponse.class);
    }

}
