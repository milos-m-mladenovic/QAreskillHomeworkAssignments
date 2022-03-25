package test.common;

import calls.RegistrationAndAuthenticationAPI;
import data.models.registration.authentication.LoginRequest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://test-api.k6.io/";
        accessToken = RegistrationAndAuthenticationAPI.login(new LoginRequest("milosm", "test123")).getAccess();

    }

}
