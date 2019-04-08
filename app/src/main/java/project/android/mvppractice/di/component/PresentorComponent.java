package project.android.mvppractice.di.component;


import dagger.Component;
import project.android.mvppractice.UI.splash.SplashActivity;
import project.android.mvppractice.di.module.SplashModule;
import project.android.mvppractice.di.scope.ActivityScope;

@ActivityScope
@Component (dependencies = AppComponent.class,modules = {SplashModule.class})
public interface PresentorComponent {




    void inject(SplashActivity splashActivity);





}
