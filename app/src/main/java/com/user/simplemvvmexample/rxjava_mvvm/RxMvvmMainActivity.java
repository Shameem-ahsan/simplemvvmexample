package com.user.simplemvvmexample.rxjava_mvvm;


import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.user.simplemvvmexample.R;
import retrofit2.Retrofit;


public class RxMvvmMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Retrofit retrofit;
    HeroesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeroes().observe(this, heroList -> {

            adapter = new HeroesAdapter(RxMvvmMainActivity.this, heroList);
            recyclerView.setAdapter(adapter);
        });

    }
}
