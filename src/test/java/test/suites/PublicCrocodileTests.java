package test.suites;

import calls.PublicAPI;
import data.models.common.CrocodileResponse;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class PublicCrocodileTests extends TestBase {

    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void getListOfPublicCrocodiles() {
        CrocodileResponse[] getPublicCrocodileResponse = PublicAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    public void getSinglePublicCrocodile() {
        CrocodileResponse[] getPublicCrocodileResponse = PublicAPI.getPublicCrocodileResponse();
        CrocodileResponse crocodileResponse = PublicAPI.getSinglePublicCrocodile(getPublicCrocodileResponse[0].getId());
        crocodileAsserts.assertSinglePublicCrocodile(crocodileResponse);
    }

}
