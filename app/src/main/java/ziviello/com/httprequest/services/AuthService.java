package ziviello.com.httprequest.services;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ziviello.com.httprequest.models.AuthModel;
import ziviello.com.httprequest.utility.Settings;

/**
 * Created by fabio on 11/01/2018.
 */

public interface AuthService {

    /**
     * @return HTTP Response
     */

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST(Settings.LOGIN_PATH)
    Call<AuthModel> login(
            @Field("email") String username,
            @Field("password") String password
    );

}
