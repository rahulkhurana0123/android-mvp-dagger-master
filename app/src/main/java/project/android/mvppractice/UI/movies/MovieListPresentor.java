package project.android.mvppractice.UI.movies;

import android.content.Context;

import java.util.List;

import project.android.mvppractice.model.Movie;
import project.android.mvppractice.model.MoviesResponse;
import project.android.mvppractice.rest.ApiClient;
import project.android.mvppractice.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rahul khurana on 09/04/19.
 */


public class MovieListPresentor implements MovieListMvpPresentor{

    MovieListMvpView movieListMvpView;

    Context context;

    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";


    public MovieListPresentor(MovieListMvpView movieListMvpView, Context context) {

        this.movieListMvpView = movieListMvpView;
        this.context = context;



    }

    @Override
    public void onCreate() {


        movieListMvpView.showProgress();
        if (API_KEY.isEmpty()) {
            movieListMvpView.onError("Please obtain your API KEY from themoviedb.org first!");
            return;
        }
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                List<Movie> movies = response.body().getResults();
                movieListMvpView.hideProgress();
                movieListMvpView.displayMovies(movies);

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                movieListMvpView.hideProgress();
                movieListMvpView.onError(t.toString());

            }
        });

    }
}
