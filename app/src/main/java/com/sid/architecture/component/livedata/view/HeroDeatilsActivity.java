package com.sid.architecture.component.livedata.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sid.architecture.component.R;
import com.sid.architecture.component.livedata.model.Hero;
import com.sid.architecture.component.livedata.view.adapter.HeroesAdapter;
import com.sid.architecture.component.livedata.viewmodel.HeroesViewModel;

import java.util.List;

public class HeroDeatilsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HeroesAdapter adapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_deatils);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroesViewModel heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel.class);
        //  ArticleViewModel articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);

        heroesViewModel.getHeroList().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(HeroDeatilsActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
