package project.android.mvppractice.UI.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import javax.inject.Inject;

import project.android.MyApp;
import project.android.mvppractice.UI.home.MainActivity;
import project.android.mvppractice.R;
import project.android.mvppractice.UI.Login.LoginActivity;
import project.android.mvppractice.di.component.DaggerPresentorComponent;
import project.android.mvppractice.di.component.PresentorComponent;
import project.android.mvppractice.di.module.SplashModule;

public class SplashActivity extends AppCompatActivity implements SplashMvpView {


    PresentorComponent presentorComponent;

    @Inject
    Presentor presentor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        presentorComponent = DaggerPresentorComponent.builder().appComponent(((MyApp) getApplicationContext()).getAppComponent())
                .splashModule(new SplashModule(SplashActivity.this)).build();
        presentorComponent.inject(SplashActivity.this);


        presentor.onCreate();


    }

    @Override
    public void openLoginActivity() {

        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void openMainActiivity() {

        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();


    }
}
