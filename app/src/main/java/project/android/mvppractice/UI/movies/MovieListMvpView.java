package project.android.mvppractice.UI.movies;

import java.util.List;

import project.android.mvppractice.model.Movie;
/**
 * Created by Rahul khurana on 09/04/19.
 */

public interface MovieListMvpView {


    void displayMovies(List<Movie> movieList);

    void onError(String message);

    void showProgress();

    void hideProgress();


}
