package com.user.simplemvvmexample.mvp;

import com.user.simplemvvmexample.Hero;

import java.util.List;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetHeroIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetHeroIntractor getNoticeIntractor;

    public MainPresenterImpl(MvpMainActivity mainView, MainContract.GetHeroIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getNoticeIntractor.getNoticeArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this);
    }


    @Override
    public void onFinished(List<Hero> noticeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}