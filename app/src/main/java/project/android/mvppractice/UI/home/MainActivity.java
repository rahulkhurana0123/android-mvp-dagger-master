package project.android.mvppractice.UI.home;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.android.mvppractice.R;
import project.android.mvppractice.UI.movies.MovieListActivity;
import project.android.mvppractice.adapter.AlbumsAdapter;
import project.android.mvppractice.di.component.DaggerMainComponent;
import project.android.mvppractice.di.component.MainComponent;
import project.android.mvppractice.di.module.MainModule;
import project.android.mvppractice.model.Album;

public class MainActivity extends AppCompatActivity implements MainMvpView{


    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.love_music)
    TextView loveMusic;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    AlbumsAdapter adapter;


    @Inject
    MainMvpPresentor mainMvpPresentor;


    MainComponent mainComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();

        mainComponent.inject(this);

        initCollapsingToolbar();

        mainMvpPresentor.onCreate();





        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter.notifyDataSetChanged();

    }

    private void initCollapsingToolbar() {

        collapsingToolbar.setTitle(" ");
        appbar.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void displayAlbum(List<Album> albumList) {


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.addItems(albumList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void launchMovieListActivity() {


startActivity(new Intent(this,MovieListActivity.class));
    }


    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
