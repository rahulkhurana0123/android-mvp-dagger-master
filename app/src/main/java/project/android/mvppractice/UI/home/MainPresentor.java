package project.android.mvppractice.UI.home;


import project.android.mvppractice.model.Album;

public class MainPresentor implements MainMvpPresentor {

    MainMvpView mainMvpView;

    public MainPresentor(MainMvpView mainMvpView) {

        this.mainMvpView = mainMvpView;

    }

    @Override
    public void onCreate() {

        mainMvpView.displayAlbum(new Album().prepareAlbums());

    }

    @Override
    public void onAlbumItemClick() {

        mainMvpView.launchMovieListActivity();
    }
}
