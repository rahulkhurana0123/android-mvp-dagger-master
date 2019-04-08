package project.android.mvppractice.UI.movies;

import java.util.List;

import project.android.mvppractice.model.Movie;

public interface MovieListMvpView {


    void displayMovies(List<Movie> movieList);

    void onError(String message);

    void showProgress();

    void hideProgress();


}
