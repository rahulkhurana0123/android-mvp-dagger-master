package project.android.mvppractice.di.component;


import dagger.Component;
import project.android.mvppractice.UI.Login.LoginActivity;
import project.android.mvppractice.di.module.LoginModule;
import project.android.mvppractice.di.scope.ActivityScope;

@ActivityScope
@Component (dependencies = AppComponent.class,modules = LoginModule.class)
public interface LoginComponent {


    void inject(LoginActivity loginActivity);




}
