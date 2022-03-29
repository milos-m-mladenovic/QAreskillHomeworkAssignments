package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.common.CrocodileRequest;

public class CrocodileProvider {

    public static CrocodileRequest prepareCrocodileRequest() {
        CrocodileRequest crocodileRequest = new CrocodileRequest();
        crocodileRequest.setName(Faker.instance().name().firstName());
        crocodileRequest.setSex(ValueChoosers.setRandomSex());
        crocodileRequest.setDateOfBirth(ValueChoosers.setDob());
        return crocodileRequest;
    }

}
