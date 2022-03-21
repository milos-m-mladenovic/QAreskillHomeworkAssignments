package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.privateapis.*;
import data.models.publicapis.GetPublicCrocodileResponse;
import data.models.publicapis.GetSinglePublicCrocodileResponse;
import data.models.registration.authentication.LoginRequest;
import data.models.registration.authentication.LoginResponse;
import data.models.registration.authentication.RegisterNewUserRequest;
import data.models.registration.authentication.RegisterNewUserResponse;

public class CrocodilesAPI {

    public static RegisterNewUserResponse register(RegisterNewUserRequest registerNewUserRequest ) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("user/register/", registerNewUserRequest), RegisterNewUserResponse.class);
    }

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), GetPublicCrocodileResponse[].class);
    }

    public static GetSinglePublicCrocodileResponse getSinglePublicCrocodile(int id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/" + id + "/"), GetSinglePublicCrocodileResponse.class);
    }

    public static GetSinglePrivateCrocodileResponse getSinglePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/" + id + "/", accessToken), GetSinglePrivateCrocodileResponse.class);
    }

    public static GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodiles(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken), GetAllPrivateCrocodilesResponse[].class);
    }

    public static PutPrivateCrocodileResponse putPrivateCrocodile(int id, String accessToken, PutPrivateCrocodileRequest putPrivateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + id + "/", accessToken, putPrivateCrocodileRequest), PutPrivateCrocodileResponse.class);
    }

    public static PatchPrivateCrocodileResponse patchPrivateCrocodile(int id, String accessToken, PatchPrivateCrocodileRequest patchPrivateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/" + id + "/", accessToken, patchPrivateCrocodileRequest), PatchPrivateCrocodileResponse.class);
    }

    public static DeletePrivateCrocodileResponse deletePrivateCrocodile(int id, String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/" + id + "/", accessToken), DeletePrivateCrocodileResponse.class);
    }

}
