package com.user.simplemvvmexample.dagger_common;

import android.app.Application;



import static com.user.simplemvvmexample.Api.BASE_URL;


public class MyApplication extends Application {

    private ApiComponent mApiComponent;
    private static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(BASE_URL))
                .build();
    }
    public static MyApplication getApp() {
        return app;
    }
    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}