package ziviello.com.httprequest.views;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ziviello.com.httprequest.R;
import ziviello.com.httprequest.presenters.LoginPresenter;
import ziviello.com.httprequest.presenters.LoginPresenterImpl;
import ziviello.com.httprequest.interfaces.LoginInterface;

public class LoginActivity extends AppCompatActivity  implements LoginInterface {

    LoginPresenter loginPresenter;

    private ProgressDialog ProgressLoading;
    private Button btnLogin;
    private EditText edit_email;
    private EditText edit_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImpl(this);

        btnLogin = (Button) findViewById(R.id.id_btn_login);
        edit_email = (EditText) findViewById(R.id.id_edit_email);
        edit_pwd = (EditText) findViewById(R.id.id_edit_pwd);

        ProgressLoading = new ProgressDialog(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.callLogin(edit_email.getText().toString(), edit_pwd.getText().toString());
            }
        });
    }

    @Override
    public void toast(String msg) {
        Toast toast = Toast.makeText(this, msg , Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showProgress() {

        ProgressLoading.setTitle("");
        ProgressLoading.setCancelable(false);
        ProgressLoading.setMessage("Caricamento in corso...");
        ProgressLoading.show();
    }

    @Override
    public void hideProgress() {
        ProgressLoading.cancel();
    }
}