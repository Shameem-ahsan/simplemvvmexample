package com.user.simplemvvmexample.dagger_common;

import com.user.simplemvvmexample.dagger_mvc.DaggerMvcMainActivity;
import com.user.simplemvvmexample.dagger_mvvm.DaggerMvvmMainActivity;
import com.user.simplemvvmexample.dagger_mvvm.HeroesViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(DaggerMvvmMainActivity activity);

    void inject(HeroesViewModel heroesViewModel);

    void inject(DaggerMvcMainActivity mainActivity);
}