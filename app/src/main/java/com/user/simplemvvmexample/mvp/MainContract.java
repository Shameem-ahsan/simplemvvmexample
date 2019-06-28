package com.user.simplemvvmexample.mvp;

import com.user.simplemvvmexample.Hero;

import java.util.List;

public interface MainContract {


    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }


    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Hero> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }


    interface GetHeroIntractor {

        interface OnFinishedListener {
            void onFinished(List<Hero> noticeArrayList);
            void onFailure(Throwable t);
        }
        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}