package project.android.mvppractice.di.module;


import dagger.Module;
import dagger.Provides;
import project.android.mvppractice.UI.Login.LoginMvpPresntor;
import project.android.mvppractice.UI.Login.LoginMvpView;
import project.android.mvppractice.UI.Login.LoginPresentor;
import project.android.mvppractice.di.scope.ActivityScope;
import project.android.mvppractice.preferences.LoginDataManager;
import project.android.mvppractice.preferences.Preference;

/**
 * Created by Rahul khurana on 09/04/19.
 */

@Module
public class LoginModule {

    LoginMvpView loginMvpView;

    public LoginModule(LoginMvpView loginMvpView) {
        this.loginMvpView = loginMvpView;
    }


    @ActivityScope
    @Provides
    LoginDataManager providesLoginDataManager() {
        return new LoginDataManager();
    }

    @ActivityScope
    @Provides
    LoginMvpView providesLoginMvpView() {
        return loginMvpView;
    }


    @ActivityScope
    @Provides
    LoginMvpPresntor providesloginMvpPresntor(LoginMvpView loginMvpView, LoginDataManager loginDataManager, Preference preference) {
        return new LoginPresentor(loginMvpView, loginDataManager, preference);
    }

}
