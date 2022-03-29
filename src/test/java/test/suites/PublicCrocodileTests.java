package test.suites;

import calls.PublicAPI;
import data.models.common.CrocodileResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class PublicCrocodileTests extends TestBase {

    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
    CrocodileResponse[] getPublicCrocodileResponse;

    @BeforeMethod
    public void prepareTestData() {
        getPublicCrocodileResponse = PublicAPI.getPublicCrocodileResponse();
    }

    @Test
    public void getListOfPublicCrocodiles() {
        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    public void getSinglePublicCrocodile() {
        CrocodileResponse crocodileResponse = PublicAPI.getSinglePublicCrocodile(getPublicCrocodileResponse[0].getId());
        crocodileAsserts.assertSinglePublicCrocodile(crocodileResponse);
    }

}
