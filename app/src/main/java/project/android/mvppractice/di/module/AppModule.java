package project.android.mvppractice.di.module;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import project.android.mvppractice.preferences.Preference;

@Module
public class AppModule {

    Context context;

   public AppModule(Context context){

       this.context = context;

    }

    @Provides
    @Singleton
    Context provideAppContext(){
       return context;
    }


    @Provides
    @Singleton
    Preference providePrefereces(Context context){

        return new Preference(context);

    }


}
