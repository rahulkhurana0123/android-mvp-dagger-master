package project.android.mvppractice.di.component;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import project.android.MyApp;
import project.android.mvppractice.di.module.AppModule;
import project.android.mvppractice.preferences.Preference;

/**
 * Created by Rahul khurana on 09/04/19.
 */

@Singleton
@Component (modules = AppModule.class)
public interface AppComponent {
    void inject(MyApp myApp);


    Context providesContext();

    Preference providesPreferences();




}
