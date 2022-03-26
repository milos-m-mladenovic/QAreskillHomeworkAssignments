package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.registration.authentication.LoginRequest;
import data.models.registration.authentication.LoginResponse;
import data.models.registration.authentication.RegisterNewUserRequest;
import data.models.registration.authentication.RegisterNewUserResponse;

public class RegistrationAndAuthenticationAPI {

    public static RegisterNewUserResponse register(RegisterNewUserRequest registerNewUserRequest ) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("user/register/", registerNewUserRequest), RegisterNewUserResponse.class);
    }

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }



}