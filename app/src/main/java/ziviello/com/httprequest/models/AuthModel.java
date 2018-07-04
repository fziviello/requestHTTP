package ziviello.com.httprequest.models;

/**
 * Created by fabio on 13/09/2017.
 */

public class AuthModel {

    private static AuthModel instance;

    private String token = "";

    public static synchronized AuthModel getInstance() {
        if(instance == null) { instance = new AuthModel(); }
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}