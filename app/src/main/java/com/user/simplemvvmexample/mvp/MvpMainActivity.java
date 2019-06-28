package com.user.simplemvvmexample.mvp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.user.simplemvvmexample.Hero;
import com.user.simplemvvmexample.R;

import java.util.List;


public class MvpMainActivity extends AppCompatActivity implements MainContract.MainView {

    RecyclerView recyclerView;
    private MainContract.presenter presenter;
    HeroesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MainPresenterImpl(this, new GetHeroIntractorImpl());
        presenter.requestDataFromServer();


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(List<Hero> noticeArrayList) {
        adapter = new HeroesAdapter(MvpMainActivity.this, noticeArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}