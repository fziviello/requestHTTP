package ziviello.com.httprequest.services;

import ziviello.com.httprequest.utility.Settings;

/**
 * Created by Fabio on 12/01/18.
 */

public class ApiUtils {

    private ApiUtils(){}

    public static AuthService getApiService(){
        return RetrofitClient.getClient(Settings.BASE_PATH).create(AuthService.class);
    }

}
