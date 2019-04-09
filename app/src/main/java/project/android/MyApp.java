package project.android;

import android.app.Application;
import android.content.Context;

import project.android.mvppractice.di.component.AppComponent;
import project.android.mvppractice.di.component.DaggerAppComponent;
import project.android.mvppractice.di.module.AppModule;

/**
 * Created by Rahul khurana on 09/04/19.
 */

public class MyApp extends Application {


  private AppComponent appComponent;


   Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();

        appComponent.inject(MyApp.this);
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }
}
