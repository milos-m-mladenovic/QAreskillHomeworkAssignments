package constants;

public class PublicApiEndpoints {

    //Crocodiles
    public static final String CROCODILES = "public/crocodiles/";

    //Single crocodile
    public static String SINGLE_CROCODILE(int id) { return CROCODILES + id + "/"; }

}
