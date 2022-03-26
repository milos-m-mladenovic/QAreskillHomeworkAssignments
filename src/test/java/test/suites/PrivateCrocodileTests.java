package test.suites;

import calls.PrivateAPI;
import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class PrivateCrocodileTests extends TestBase {

    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void getListOfPrivateCrocodiles() {
        CrocodileResponse[] getAllPrivateCrocodilesResponse = PrivateAPI.getAllPrivateCrocodiles(accessToken);
        crocodileAsserts.assertAllPrivateCrocodiles(getAllPrivateCrocodilesResponse);
    }

    @Test
    public void getSinglePrivateCrocodile() {
        CrocodileResponse[] getAllPrivateCrocodilesResponse = PrivateAPI.getAllPrivateCrocodiles(accessToken);
        CrocodileResponse crocodileResponse = PrivateAPI.getSinglePrivateCrocodile(getAllPrivateCrocodilesResponse[0].getId(), accessToken);
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, crocodileResponse);
    }

    @Test
    public void createCrocodile() {
        CrocodileRequest createCrocodileRequest = new CrocodileRequest("Krok", "M", "2000-01-01");
        CrocodileResponse crocodileResponse = PrivateAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(createCrocodileRequest, crocodileResponse);
    }

    @Test
    public void putSinglePrivateCrocodile() {
        CrocodileResponse[] getAllPrivateCrocodilesResponse = PrivateAPI.getAllPrivateCrocodiles(accessToken);
        CrocodileResponse crocodileResponse = PrivateAPI.getSinglePrivateCrocodile(getAllPrivateCrocodilesResponse[0].getId(), accessToken);
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, crocodileResponse);

        // I will modify this in the DataProvider exercise
        String newName = crocodileResponse.getName() + "1";
        String oldSex = crocodileResponse.getSex();
        String newSex = "M";
        if (oldSex.equals("M")) {
            newSex = "F";
        }
        String oldDateOfBirth = crocodileResponse.getDateOfBirth();
        String newDateOfBirth = "2020-01-01";
        if (oldDateOfBirth.equals("2020-01-01")) {
            newDateOfBirth = "2000-02-02";
        }

        CrocodileRequest putCrocodileRequest = new CrocodileRequest(crocodileResponse.getId(), newName, newSex, newDateOfBirth, crocodileResponse.getAge());
        CrocodileResponse crocodileResponseNew = PrivateAPI.putPrivateCrocodile(crocodileResponse.getId(), accessToken, putCrocodileRequest);
        crocodileAsserts.assertPutPrivateCrocodile(crocodileResponseNew, crocodileResponse);

    }

    @Test
    public void patchSinglePrivateCrocodile() {
        CrocodileResponse[] getAllPrivateCrocodilesResponse = PrivateAPI.getAllPrivateCrocodiles(accessToken);
        CrocodileResponse crocodileResponse = PrivateAPI.getSinglePrivateCrocodile(getAllPrivateCrocodilesResponse[0].getId(), accessToken);
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, crocodileResponse);

        String newName = crocodileResponse.getName() + "1";

        CrocodileRequest patchCrocodileRequest = new CrocodileRequest(crocodileResponse.getId(), newName, crocodileResponse.getSex(), crocodileResponse.getDateOfBirth(), crocodileResponse.getAge());
        CrocodileResponse crocodileResponseNew = PrivateAPI.patchPrivateCrocodile(crocodileResponse.getId(), accessToken, patchCrocodileRequest);
        crocodileAsserts.assertPatchPrivateCrocodile(crocodileResponseNew, crocodileResponse);

    }

    @Test
    public void deleteSinglePrivateCrocodile() {
        CrocodileRequest createCrocodileRequest = new CrocodileRequest("Krok", "M", "2000-01-01");
        CrocodileResponse crocodileResponse = PrivateAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileResponse = PrivateAPI.getSinglePrivateCrocodile(crocodileResponse.getId(), accessToken);

        CrocodileResponse deleteResponse = PrivateAPI.deletePrivateCrocodile(crocodileResponse.getId(), accessToken);
        Assert.assertNull(deleteResponse);
    }

}
