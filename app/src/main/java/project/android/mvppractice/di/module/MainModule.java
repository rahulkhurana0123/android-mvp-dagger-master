package project.android.mvppractice.di.module;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import project.android.mvppractice.UI.home.MainMvpPresentor;
import project.android.mvppractice.UI.home.MainMvpView;
import project.android.mvppractice.UI.home.MainPresentor;
import project.android.mvppractice.adapter.AlbumsAdapter;
import project.android.mvppractice.di.scope.ActivityScope;
import project.android.mvppractice.model.Album;

@Module
public class MainModule {

    MainMvpView mainMvpView;


    public MainModule(MainMvpView mainMvpView) {
        this.mainMvpView = mainMvpView;
    }

    @Provides
    @ActivityScope
    List<Album> provideAlbumList() {
        return new Album().prepareAlbums();
    }

    @Provides
    @ActivityScope
    AlbumsAdapter provideAlbumAdapter(List<Album> albumList,MainMvpPresentor mainMvpPresentor) {
        return new AlbumsAdapter(albumList,mainMvpPresentor);
    }

    @Provides
    @ActivityScope
    MainMvpView providesMainMvpView() {
        return mainMvpView;
    }

    @Provides
    @ActivityScope
    MainMvpPresentor providesMainMvpPresentor(MainMvpView mainMvpView) {
        return new MainPresentor(mainMvpView);
    }


}
