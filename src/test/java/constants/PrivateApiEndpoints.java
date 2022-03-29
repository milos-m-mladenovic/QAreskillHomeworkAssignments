package constants;

public class PrivateApiEndpoints {

    //Crocodiles
    public static final String CROCODILES = "my/crocodiles/";

    //Single crocodile
    public static String SINGLE_CROCODILE(int id) { return CROCODILES + id + "/"; }

}
