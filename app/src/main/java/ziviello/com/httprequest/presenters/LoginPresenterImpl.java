package ziviello.com.httprequest.presenters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ziviello.com.httprequest.models.AuthModel;
import ziviello.com.httprequest.services.ApiUtils;
import ziviello.com.httprequest.services.AuthService;
import ziviello.com.httprequest.views.LoginActivity;
import ziviello.com.httprequest.interfaces.LoginInterface;

/**
 * Created by fziviello on 31/01/18.
 */

public class LoginPresenterImpl implements LoginPresenter {

    LoginInterface loginInterface;
    private AuthService authService;

    public LoginPresenterImpl(LoginActivity loginInterface) {
        this.loginInterface = loginInterface;
    }

    @Override
    public void callLogin(String username, final String password) {

        loginInterface.showProgress();

        authService = ApiUtils.getApiService();

        authService.login(
                username,
                password)
                .enqueue(new Callback<AuthModel>() {
                    @Override
                    public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {

                        if(response.code()<400)
                        {
                            AuthModel modelLogin=response.body();
                            modelLogin.setToken(modelLogin.getToken());

                            loginInterface.toast("Token: "+ modelLogin.getToken());
                        }
                        else
                        {
                            loginInterface.toast("Errore Login: "+ response.code());
                        }

                        loginInterface.hideProgress();
                    }

                    @Override
                    public void onFailure(Call<AuthModel> call, Throwable t) {
                        loginInterface.toast("Errore Chiamata HTTP");
                        loginInterface.hideProgress();
                    }
                });
    }
}