package project.android.mvppractice.UI.Login;

import project.android.mvppractice.preferences.LoginDataManager;
import project.android.mvppractice.preferences.Preference;

public class LoginPresentor implements LoginMvpPresntor{


    LoginMvpView loginMvpView;
    LoginDataManager loginDataManager;
    Preference preference;



   public LoginPresentor(LoginMvpView loginMvpView, LoginDataManager loginDataManager, Preference preference){

       this.loginMvpView = loginMvpView;
       this.loginDataManager = loginDataManager;
       this.preference = preference;

    }


        @Override
    public void onClickLogin(final String username, final String password) {

       loginMvpView.showPregoress();

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
// wait for 2 sec to show progress
                    if( loginDataManager.checkCrendentials(username,password)){

                        preference.setLoggedIn(true);
                        loginMvpView.openHomeActivity();

                    }
                    else{
                        loginMvpView.showError();
                    }
                    loginMvpView.hideProgress();
                }
            },4000);




    }
}
