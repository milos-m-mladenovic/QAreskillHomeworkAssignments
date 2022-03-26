package test.common;

import calls.RegistrationAndAuthenticationAPI;
import data.models.registration.authentication.LoginRequest;
import environment.ConfigReader;
import environment.ConfigSetup;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = ConfigSetup.getBaseUrl();
        accessToken = RegistrationAndAuthenticationAPI.login(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getDefaultPassword())).getAccess();

    }

}
