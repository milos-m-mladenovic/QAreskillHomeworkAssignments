package test.asserts;

import data.models.common.CrocodileResponse;
import data.models.privateapis.*;
import data.models.publicapis.GetPublicCrocodileResponse;
import data.models.registration.authentication.RegisterNewUserRequest;
import data.models.registration.authentication.RegisterNewUserResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertCreateNewCrocodile(CreateCrocodileRequest createCrocodileRequest, CrocodileResponse crocodileResponse) {
        softAssert.assertEquals(crocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match.");
        softAssert.assertEquals(crocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "DOB didn't match.");
        softAssert.assertEquals(crocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match.");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponses) {
        for(int i = 0; i < getPublicCrocodileResponses.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponses[i].getName().isEmpty(), "Name is empty.");
            softAssert.assertFalse(getPublicCrocodileResponses[i].getDateOfBirth().isEmpty(), "DOB is empty.");
            softAssert.assertFalse(getPublicCrocodileResponses[i].getSex().isEmpty(), "Sex is empty.");
        }
        softAssert.assertAll();
    }

    public void assertSinglePublicCrocodile(CrocodileResponse crocodileResponse) {
        softAssert.assertFalse(crocodileResponse.getName().isEmpty(), "Name is empty.");
        softAssert.assertFalse(crocodileResponse.getDateOfBirth().isEmpty(), "DOB is empty.");
        softAssert.assertFalse(crocodileResponse.getSex().isEmpty(), "Sex is empty.");
        softAssert.assertAll();
    }

    public void assertSinglePrivateCrocodile(GetAllPrivateCrocodilesResponse[] getAllPrivateCrocodilesResponses, CrocodileResponse crocodileResponse) {
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getId(), crocodileResponse.getId());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getName(), crocodileResponse.getName());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getSex(), crocodileResponse.getSex());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getDateOfBirth(), crocodileResponse.getDateOfBirth());
        softAssert.assertEquals(getAllPrivateCrocodilesResponses[0].getAge(), crocodileResponse.getAge());
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

    public  void  assertPutPrivateCrocodile(CrocodileResponse crocodileResponseNew, CrocodileResponse crocodileResponse) {
        softAssert.assertFalse(crocodileResponseNew.getName().equals(crocodileResponse.getName()));
        softAssert.assertFalse(crocodileResponseNew.getSex().equals(crocodileResponse.getSex()));
        softAssert.assertFalse(crocodileResponseNew.getDateOfBirth().equals(crocodileResponse.getDateOfBirth()));
        softAssert.assertFalse(crocodileResponseNew.getAge().equals(crocodileResponse.getAge()));
        softAssert.assertAll();
    }

    public void assertPatchPrivateCrocodile(CrocodileResponse crocodileResponseNew, CrocodileResponse crocodileResponse) {
        softAssert.assertFalse(crocodileResponseNew.getName().equals(crocodileResponse.getName()));
        softAssert.assertAll();
    }

}
