package test.suites;

import calls.PrivateAPI;
import common.ValueChoosers;
import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;
import data.provider.CrocodileProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class PrivateCrocodileTests extends TestBase {

    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
    CrocodileRequest createCrocodileRequest;
    CrocodileResponse newCrocodile;
    CrocodileResponse[] getAllPrivateCrocodilesResponse;

    @BeforeMethod
    public void prepareTestData() {
        createCrocodileRequest = CrocodileProvider.prepareCrocodileRequest();
        newCrocodile = PrivateAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        getAllPrivateCrocodilesResponse = PrivateAPI.getAllPrivateCrocodiles(accessToken);
    }

    @AfterMethod
    public void dataCleanup() {
            PrivateAPI.deletePrivateCrocodile(newCrocodile.getId(), accessToken);
    }

    @Test
    public void getListOfPrivateCrocodiles() {
        crocodileAsserts.assertAllPrivateCrocodiles(getAllPrivateCrocodilesResponse);
    }

    @Test
    public void getSinglePrivateCrocodile() {
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, newCrocodile);
    }

    @Test
    public void createCrocodile() {
        crocodileAsserts.assertCreateNewCrocodile(createCrocodileRequest, newCrocodile);
    }

    @Test
    public void putSinglePrivateCrocodile() {
        CrocodileRequest putCrocodileRequest = new CrocodileRequest(newCrocodile.getId(), ValueChoosers.setRandomName(), ValueChoosers.newSex(newCrocodile.getSex()), ValueChoosers.setDob(), newCrocodile.getAge());
        CrocodileResponse crocodileResponseNew = PrivateAPI.putPrivateCrocodile(newCrocodile.getId(), accessToken, putCrocodileRequest);
        crocodileAsserts.assertPutPrivateCrocodile(crocodileResponseNew, newCrocodile);

    }

    @Test
    public void patchSinglePrivateCrocodile() {
        CrocodileRequest patchCrocodileRequest = new CrocodileRequest(newCrocodile.getId(), ValueChoosers.setRandomName(), newCrocodile.getSex(), newCrocodile.getDateOfBirth(), newCrocodile.getAge());
        CrocodileResponse crocodileResponseNew = PrivateAPI.patchPrivateCrocodile(newCrocodile.getId(), accessToken, patchCrocodileRequest);
        crocodileAsserts.assertPatchPrivateCrocodile(crocodileResponseNew, newCrocodile);

    }

    @Test
    public void deleteSinglePrivateCrocodile() {
        CrocodileResponse deleteResponse = PrivateAPI.deletePrivateCrocodile(newCrocodile.getId(), accessToken);
        Assert.assertNull(deleteResponse);
    }

}
