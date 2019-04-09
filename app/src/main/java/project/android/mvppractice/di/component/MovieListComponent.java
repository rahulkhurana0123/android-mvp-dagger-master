package project.android.mvppractice.di.component;


import dagger.Component;
import project.android.mvppractice.UI.movies.MovieListActivity;
import project.android.mvppractice.di.module.MovieListModule;
import project.android.mvppractice.di.scope.ActivityScope;

/**
 * Created by Rahul khurana on 09/04/19.
 */

@ActivityScope
@Component(modules = MovieListModule.class)
public interface MovieListComponent {

    void inject(MovieListActivity movieListActivity);

}
