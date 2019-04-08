package project.android.mvppractice.di.component;


import dagger.Component;
import project.android.mvppractice.UI.home.MainActivity;
import project.android.mvppractice.di.module.MainModule;
import project.android.mvppractice.di.scope.ActivityScope;

@ActivityScope
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
