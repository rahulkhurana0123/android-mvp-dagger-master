package project.android.mvppractice.UI.splash;

import project.android.mvppractice.preferences.Preference;

public class SplashPresentor implements Presentor {

    SplashMvpView splashMvpView;
Preference preference;

    public SplashPresentor(SplashMvpView splashMvpView,Preference preference){
        this.splashMvpView = splashMvpView;
        this.preference = preference;

    }

    @Override
    public void onCreate() {
        decideActivity();

    }

public void decideActivity(){

    new android.os.Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            if(!preference.isLoggedIn()){
                splashMvpView.openLoginActivity();
            }
            else{
                splashMvpView.openMainActiivity();

            }


        }
    },2000);

}




}
