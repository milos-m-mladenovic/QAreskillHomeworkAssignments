package test.suites;

import calls.CrocodilesAPI;
import data.models.privateapis.*;
import data.models.publicapis.GetPublicCrocodileResponse;
import data.models.publicapis.GetSinglePublicCrocodileResponse;
import data.models.registration.authentication.RegisterNewUserRequest;
import data.models.registration.authentication.RegisterNewUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void registerNewUser() {
        RegisterNewUserRequest registerNewUserRequest = new RegisterNewUserRequest("test543210123", "Testfirst", "Testlast", "test543210123@test.test", "test123");
        RegisterNewUserResponse registerNewUserResponse = CrocodilesAPI.register(registerNewUserRequest);
        crocodileAsserts.assertRegisterNewUser(registerNewUserResponse, registerNewUserRequest);
    }

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty.");
    }

    @Test
    public void createCrocodile() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Krok", "M", "2000-01-01");
        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(createCrocodileRequest, createCrocodileResponse);
    }

    @Test
    public void getListOfPublicCrocodiles() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    public void getListOfPrivateCrocodiles() {
        GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponse = CrocodilesAPI.getAllPrivateCrocodiles(accessToken);
        crocodileAsserts.assertAllPrivateCrocodiles(getAllPrivateCrocodilesResponse);
    }

    @Test
    public void getSinglePublicCrocodile() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);

        GetSinglePublicCrocodileResponse getSinglePublicCrocodileResponse = CrocodilesAPI.getSinglePublicCrocodile(getPublicCrocodileResponse[0].getId());
        crocodileAsserts.assertSinglePublicCrocodile(getPublicCrocodileResponse, getSinglePublicCrocodileResponse);
    }

    @Test
    public void getSinglePrivateCrocodile() {
        GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponse = CrocodilesAPI.getAllPrivateCrocodiles(accessToken);
        crocodileAsserts.assertAllPrivateCrocodiles(getAllPrivateCrocodilesResponse);

        GetSinglePrivateCrocodileResponse getSinglePrivateCrocodileResponse = CrocodilesAPI.getSinglePrivateCrocodile(getAllPrivateCrocodilesResponse[0].getId(), accessToken);
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, getSinglePrivateCrocodileResponse);
    }

    @Test
    public void putSinglePrivateCrocodile() {
        GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponse = CrocodilesAPI.getAllPrivateCrocodiles(accessToken);
        crocodileAsserts.assertAllPrivateCrocodiles(getAllPrivateCrocodilesResponse);

        GetSinglePrivateCrocodileResponse getSinglePrivateCrocodileResponse = CrocodilesAPI.getSinglePrivateCrocodile(getAllPrivateCrocodilesResponse[0].getId(), accessToken);
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, getSinglePrivateCrocodileResponse);

        String oldName = getSinglePrivateCrocodileResponse.getName();
        String newName = getSinglePrivateCrocodileResponse.getName() + "1";
        String oldSex = getSinglePrivateCrocodileResponse.getSex();
        String newSex = "M";
        if (oldSex.equals("M")) {
            newSex = "F";
        }
        String oldDateOfBirth = getSinglePrivateCrocodileResponse.getDateOfBirth();
        String newDateOfBirth = "2020-01-01";
        if (oldDateOfBirth.equals("2020-01-01")) {
            newDateOfBirth = "2000-02-02";
        }

        PutPrivateCrocodileRequest putPrivateCrocodileRequest = new PutPrivateCrocodileRequest(getSinglePrivateCrocodileResponse.getId(), newName, newSex, newDateOfBirth, getSinglePrivateCrocodileResponse.getAge());
        PutPrivateCrocodileResponse putPrivateCrocodileResponse = CrocodilesAPI.putPrivateCrocodile(getSinglePrivateCrocodileResponse.getId(), accessToken, putPrivateCrocodileRequest);
        crocodileAsserts.assertPutPrivateCrocodile(putPrivateCrocodileResponse, oldName);

    }

    @Test
    public void patchSinglePrivateCrocodile() {
        GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponse = CrocodilesAPI.getAllPrivateCrocodiles(accessToken);
        crocodileAsserts.assertAllPrivateCrocodiles(getAllPrivateCrocodilesResponse);

        GetSinglePrivateCrocodileResponse getSinglePrivateCrocodileResponse = CrocodilesAPI.getSinglePrivateCrocodile(getAllPrivateCrocodilesResponse[0].getId(), accessToken);
        crocodileAsserts.assertSinglePrivateCrocodile(getAllPrivateCrocodilesResponse, getSinglePrivateCrocodileResponse);

        String oldName = getSinglePrivateCrocodileResponse.getName();
        String newName = getSinglePrivateCrocodileResponse.getName() + "1";

        PatchPrivateCrocodileRequest patchPrivateCrocodileRequest = new PatchPrivateCrocodileRequest(getSinglePrivateCrocodileResponse.getId(), newName, getSinglePrivateCrocodileResponse.getSex(), getSinglePrivateCrocodileResponse.getDateOfBirth(), getSinglePrivateCrocodileResponse.getAge());
        PatchPrivateCrocodileResponse patchPrivateCrocodileResponse = CrocodilesAPI.patchPrivateCrocodile(getSinglePrivateCrocodileResponse.getId(), accessToken, patchPrivateCrocodileRequest);
        crocodileAsserts.assertPatchPrivateCrocodile(patchPrivateCrocodileResponse, oldName);

    }

    @Test
    public void deleteSinglePrivateCrocodile() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Krok", "M", "2000-01-01");
        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        crocodileAsserts.assertCreateNewCrocodile(createCrocodileRequest, createCrocodileResponse);

        GetSinglePrivateCrocodileResponse getSinglePrivateCrocodileResponse = CrocodilesAPI.getSinglePrivateCrocodile(createCrocodileResponse.getId(), accessToken);
        System.out.println(getSinglePrivateCrocodileResponse);

        DeletePrivateCrocodileResponse deletePrivateCrocodileResponse = CrocodilesAPI.deletePrivateCrocodile(getSinglePrivateCrocodileResponse.getId(), accessToken);
        crocodileAsserts.assertDeletePrivateCrocodile(deletePrivateCrocodileResponse);
    }

}
