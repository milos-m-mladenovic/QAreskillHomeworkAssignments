package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.common.CrocodileResponse;
import data.models.privateapis.*;

public class PrivateAPI {

    public static CrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse getSinglePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/" + id + "/", accessToken), CrocodileResponse.class);
    }

    public static GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodiles(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken), GetAllPrivateCrocodilesResponse[].class);
    }

    public static CrocodileResponse putPrivateCrocodile(int id, String accessToken, PutPrivateCrocodileRequest putPrivateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + id + "/", accessToken, putPrivateCrocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchPrivateCrocodile(int id, String accessToken, PatchPrivateCrocodileRequest patchPrivateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/" + id + "/", accessToken, patchPrivateCrocodileRequest), CrocodileResponse.class);
    }

    public static DeleteResponse deletePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/" + id + "/", accessToken), DeleteResponse.class);
    }

}
