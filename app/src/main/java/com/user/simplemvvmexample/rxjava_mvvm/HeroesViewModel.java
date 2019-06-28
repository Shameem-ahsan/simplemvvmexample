package com.user.simplemvvmexample.rxjava_mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.user.simplemvvmexample.Hero;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.user.simplemvvmexample.rxjava_mvvm.Api.BASE_URL;

public class HeroesViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Hero>> heroList;


    //we will call this method to get the data
    public LiveData<List<Hero>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {
      Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Observable<List<Hero>> heroObservable = api.getHeroes();
        heroObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }
    private void handleResults(List<Hero> marketList) {
        if (marketList != null && marketList.size() != 0) {

            heroList.setValue(marketList);

        } else {

            System.out.println("NO RESULTS FOUND");
        }
    }

    private void handleError(Throwable t) {

        System.out.println("ERROR IN FETCHING API RESPONSE. Try again");
    }


}