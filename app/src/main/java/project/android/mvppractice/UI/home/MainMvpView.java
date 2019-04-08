package project.android.mvppractice.UI.home;


import java.util.List;

import project.android.mvppractice.model.Album;

public interface MainMvpView  {


    void displayAlbum(List<Album> albumList);

    void launchMovieListActivity();


}
