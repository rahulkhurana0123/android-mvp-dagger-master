package project.android.mvppractice.di.module;


import dagger.Module;
import dagger.Provides;
import project.android.mvppractice.UI.splash.Presentor;
import project.android.mvppractice.UI.splash.SplashMvpView;
import project.android.mvppractice.UI.splash.SplashPresentor;
import project.android.mvppractice.di.scope.ActivityScope;
import project.android.mvppractice.preferences.Preference;


/**
 * Created by Rahul khurana on 09/04/19.
 */

@Module
public class SplashModule {

SplashMvpView splashMvpView;


public SplashModule(SplashMvpView splashMvpView){
   this.splashMvpView = splashMvpView;

}


@ActivityScope
@Provides
SplashMvpView providesSplashMvpView(){
    return splashMvpView;
}



@ActivityScope
@Provides
Presentor providesSplashMvpPresentor(SplashMvpView splashMvpView,Preference preference){


   return new SplashPresentor(splashMvpView,preference);
}



}
