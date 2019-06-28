package com.user.simplemvvmexample.rxjava_mvvm;

import com.user.simplemvvmexample.Hero;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Observable<List<Hero>> getHeroes();


}