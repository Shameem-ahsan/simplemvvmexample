package com.user.simplemvvmexample.mvp;

import android.util.Log;

import com.user.simplemvvmexample.Api;
import com.user.simplemvvmexample.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetHeroIntractorImpl implements MainContract.GetHeroIntractor {

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);


        Call<List<Hero>> call = api.getHeroes();


        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                onFinishedListener.onFinished(response.body());

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}