package test.asserts;

import data.models.privateapis.*;
import data.models.publicapis.GetPublicCrocodileResponse;
import data.models.publicapis.GetSinglePublicCrocodileResponse;
import data.models.registration.authentication.RegisterNewUserRequest;
import data.models.registration.authentication.RegisterNewUserResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertCreateNewCrocodile(CreateCrocodileRequest createCrocodileRequest, CreateCrocodileResponse createCrocodileResponse) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match.");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "DOB didn't match.");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match.");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponses) {
        for(int i = 0; i < getPublicCrocodileResponses.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponses[i].getName().isEmpty(), "Name is empty.");
        }
        softAssert.assertAll();
    }

    public void assertSinglePublicCrocodile(GetPublicCrocodileResponse[] getPublicCrocodileResponses, GetSinglePublicCrocodileResponse getSinglePublicCrocodileResponse) {
        softAssert.assertTrue(getPublicCrocodileResponses[0].getId().equals(getSinglePublicCrocodileResponse.getId()));
        softAssert.assertAll();
    }

    public void assertSinglePrivateCrocodile(GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponses, GetSinglePrivateCrocodileResponse getSinglePrivateCrocodileResponse) {
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getId(), getSinglePrivateCrocodileResponse.getId());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getName(), getSinglePrivateCrocodileResponse.getName());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getSex(), getSinglePrivateCrocodileResponse.getSex());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getDateOfBirth(), getSinglePrivateCrocodileResponse.getDateOfBirth());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getAge(), getSinglePrivateCrocodileResponse.getAge());
        softAssert.assertAll();
    }

    public void assertAllPrivateCrocodiles(GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponses) {
        for(int i = 0; i < getAllPrivateCrocodilesResponses.length; i++) {
            softAssert.assertFalse(getAllPrivateCrocodilesResponses[i].getName().isEmpty());
        }
        softAssert.assertAll();
    }

    public void assertRegisterNewUser(RegisterNewUserResponse registerNewUserResponse, RegisterNewUserRequest registerNewUserRequest) {
        softAssert.assertTrue(registerNewUserResponse.getEmail().equals(registerNewUserRequest.getEmail()));
        softAssert.assertTrue(registerNewUserResponse.getUsername().equals(registerNewUserRequest.getUsername()));
        softAssert.assertTrue(registerNewUserResponse.getFirstName().equals(registerNewUserRequest.getFirstName()));
        softAssert.assertTrue(registerNewUserResponse.getLastName().equals(registerNewUserRequest.getLastName()));
        softAssert.assertAll();
    }

    public  void  assertPutPrivateCrocodile(PutPrivateCrocodileResponse putPrivateCrocodileResponse, String oldName) {
        softAssert.assertFalse(putPrivateCrocodileResponse.getName().equals(oldName));
        softAssert.assertAll();
    }

    public void assertPatchPrivateCrocodile(PatchPrivateCrocodileResponse patchPrivateCrocodileResponse, String oldName) {
        softAssert.assertFalse(patchPrivateCrocodileResponse.getName().equals(oldName));
        softAssert.assertAll();
    }

    public void assertDeletePrivateCrocodile(DeletePrivateCrocodileResponse deletePrivateCrocodileResponse) {
        softAssert.assertNull(deletePrivateCrocodileResponse);
        softAssert.assertAll();
    }

}
