package data.models.registration.authentication;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse implements Serializable
{

    @SerializedName("refresh")
    @Expose
    private String refresh;
    @SerializedName("access")
    @Expose
    private String access;
    private final static long serialVersionUID = -5081631432089938168L;

    public LoginResponse() {
    }

    public LoginResponse(String refresh, String access) {
        super();
        this.refresh = refresh;
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

}