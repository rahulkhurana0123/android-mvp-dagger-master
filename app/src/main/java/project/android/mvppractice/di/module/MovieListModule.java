package project.android.mvppractice.di.module;


import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import project.android.mvppractice.UI.movies.MovieListMvpPresentor;
import project.android.mvppractice.UI.movies.MovieListMvpView;
import project.android.mvppractice.UI.movies.MovieListPresentor;
import project.android.mvppractice.adapter.MoviesAdapter;
import project.android.mvppractice.di.scope.ActivityScope;
import project.android.mvppractice.model.Movie;

/**
 * Created by Rahul khurana on 09/04/19.
 */

@Module
public class MovieListModule {

    Context context;
    MovieListMvpView movieListMvpView;



    public MovieListModule(Context context, MovieListMvpView movieListMvpView){
        this.context = context;
        this.movieListMvpView = movieListMvpView;
    }

    @ActivityScope
    @Provides
    Context providesContext(){
        return context;
    }



    @ActivityScope
    @Provides
    MovieListMvpPresentor providesMovieListMvpPresentor(Context context){
        return new MovieListPresentor(movieListMvpView,context);
    }

    @ActivityScope
    @Provides
    MoviesAdapter providesMoviesAdapter(){
        return new MoviesAdapter(new ArrayList<Movie>());
    }
}
