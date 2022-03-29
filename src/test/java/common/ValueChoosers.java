package common;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ValueChoosers {

    public static String setRandomSex() {
        ArrayList<String> sexes = new ArrayList<>();
        sexes.add("M");
        sexes.add("F");
        return sexes.get(RandomUtils.nextInt(0, sexes.size()));
    }

    public static String newSex(String oldSex) {
        String newSex = "M";
        if (oldSex.equals("M")) {
            newSex = "F";
        }
        return newSex;
    }

    public static String setDob() {
        return RandomUtils.nextInt(1900,2020) + "-" + RandomUtils.nextInt(10, 12) + "-" + RandomUtils.nextInt(10, 31);
    }

    public static String setRandomName() {
        return Faker.instance().name().firstName();
    }

}
