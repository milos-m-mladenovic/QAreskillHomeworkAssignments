package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;

public class PrivateAPI {

    public static CrocodileResponse createNewCrocodile(String accessToken, CrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse getSinglePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/" + id + "/", accessToken), CrocodileResponse.class);
    }

    public static CrocodileResponse[] getAllPrivateCrocodiles(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken), CrocodileResponse[].class);
    }

    public static CrocodileResponse putPrivateCrocodile(int id, String accessToken, CrocodileRequest putCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + id + "/", accessToken, putCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchPrivateCrocodile(int id, String accessToken, CrocodileRequest patchCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/" + id + "/", accessToken, patchCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse deletePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/" + id + "/", accessToken), CrocodileResponse.class);
    }

}
