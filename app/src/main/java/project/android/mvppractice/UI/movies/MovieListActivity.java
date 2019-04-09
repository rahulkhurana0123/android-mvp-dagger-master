package project.android.mvppractice.UI.movies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.android.mvppractice.R;
import project.android.mvppractice.adapter.MoviesAdapter;
import project.android.mvppractice.di.component.DaggerMovieListComponent;
import project.android.mvppractice.di.component.MovieListComponent;
import project.android.mvppractice.di.module.MovieListModule;
import project.android.mvppractice.model.Movie;
import project.android.mvppractice.utils.DialogUtils;

/**
 * Created by Rahul khurana on 09/04/19.
 */

public class MovieListActivity extends AppCompatActivity implements MovieListMvpView {

    private static final String TAG = MovieListActivity.class.getSimpleName();

    @BindView(R.id.movies_recycler_view)
    RecyclerView recyclerView;

    @Inject
    MoviesAdapter moviesAdapter;

    @Inject
    MovieListMvpPresentor movieListMvpPresentor;

    MovieListComponent movieListComponent;


    ProgressDialog progressDialog;

    // TODO - insert your themoviedb.org API KEY here

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie_list);
        ButterKnife.bind(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DaggerMovieListComponent.builder().movieListModule(new MovieListModule(this, this)).build().inject(this);


        movieListMvpPresentor.onCreate();


    }


    @Override
    public void displayMovies(List<Movie> movieList) {

        if (movieList != null) {
            recyclerView.setAdapter(moviesAdapter);
            moviesAdapter.addItems(movieList);

        }


    }

    @Override
    public void onError(String message) {
        if (message != null) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "something went wrong.", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void showProgress() {

        progressDialog = DialogUtils.showLoadingDialog(this);
    }

    @Override
    public void hideProgress() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

}
