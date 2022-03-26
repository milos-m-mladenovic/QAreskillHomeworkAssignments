package test.suites;

import calls.RegistrationAndAuthenticationAPI;
import data.models.registration.authentication.RegisterNewUserRequest;
import data.models.registration.authentication.RegisterNewUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class RegistrationAndAuthenticationTests extends TestBase {

    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void registerNewUser() {
        RegisterNewUserRequest registerNewUserRequest = new RegisterNewUserRequest("test543210123", "Testfirst", "Testlast", "test543210123@test.test", "test123");
        RegisterNewUserResponse registerNewUserResponse = RegistrationAndAuthenticationAPI.register(registerNewUserRequest);
        crocodileAsserts.assertRegisterNewUser(registerNewUserResponse, registerNewUserRequest);
    }

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty.");
    }

}
