package project.android.mvppractice.UI.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import project.android.MyApp;
import project.android.mvppractice.UI.home.MainActivity;
import project.android.mvppractice.R;
import project.android.mvppractice.di.component.DaggerLoginComponent;
import project.android.mvppractice.di.component.LoginComponent;
import project.android.mvppractice.di.module.LoginModule;
import project.android.mvppractice.utils.DialogUtils;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {


    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.bt_login)
    Button btLogin;

    @BindView(R.id.fab)
    FloatingActionButton fab;


    LoginComponent loginComponent;

    @Inject
    LoginMvpPresntor loginMvpPresntor;

    private String strUsername;
    private String strPassword;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        ButterKnife.bind(this);

      loginComponent =  DaggerLoginComponent.builder().appComponent(((MyApp)getApplicationContext()).getAppComponent()).loginModule(new LoginModule(this)).build();

      loginComponent.inject(this);


    }

    @Override
    public void openHomeActivity() {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();

    }

    @Override
    public void showError() {
      Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPregoress() {

      progressDialog = DialogUtils.showLoadingDialog(this);

    }

    @Override
    public void hideProgress() {

if(progressDialog != null && progressDialog.isShowing()){
    progressDialog.cancel();
}

    }

    boolean isValidate() {

         strUsername = username.getText().toString().trim();
         strPassword = password.getText().toString().trim();


        if (TextUtils.isEmpty(strUsername)) {

            Toast.makeText(this, "Please enter username", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(strPassword)) {

            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();

        } else {
            return true;
        }

        return false;

    }



    @OnClick(R.id.bt_login)
    public void onViewClicked() {

        if(isValidate()){

            loginMvpPresntor.onClickLogin(strUsername,strPassword);

        }
    }
}
