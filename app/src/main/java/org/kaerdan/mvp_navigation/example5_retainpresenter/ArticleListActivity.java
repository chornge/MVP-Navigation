package org.kaerdan.mvp_navigation.example5_retainpresenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;
import org.kaerdan.presenterretainer.PresenterActivity;

public class ArticleListActivity extends PresenterActivity implements ArticleListContract.NavigatorProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_frame, new ArticleListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public ArticleListContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        return new ArticleListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                startActivity(ArticleActivity.createIntent(ArticleListActivity.this, id));
            }

            @Override
            public void openFavoriteArticles() {
                startActivity(new Intent(ArticleListActivity.this, FavoriteListActivity.class));
            }
        };
    }
}