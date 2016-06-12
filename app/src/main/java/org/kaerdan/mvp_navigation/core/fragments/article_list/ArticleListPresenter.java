package org.kaerdan.mvp_navigation.core.fragments.article_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;

public class ArticleListPresenter implements ArticleListContract.Presenter, OnArticleClickListener {

    private ArticleListContract.View view;

    @Override
    public void onAttachView(ArticleListContract.View view) {
        this.view = view;

        //Usually this call goes asynchronous but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getArticles(), this);
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onArticleClick(int id) {

    }
}
