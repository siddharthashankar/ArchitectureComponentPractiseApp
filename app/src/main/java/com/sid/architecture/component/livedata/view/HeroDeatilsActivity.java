package com.sid.architecture.component.livedata.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.sid.architecture.component.R;
import com.sid.architecture.component.livedata.model.Hero;
import com.sid.architecture.component.livedata.view.adapter.HeroesAdapter;
import com.sid.architecture.component.livedata.viewmodel.HeroesViewModel;
import com.sid.architecture.component.utils.LoadingDialog;

import java.util.List;

public class HeroDeatilsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HeroesAdapter adapter;
    List<Hero> heroList;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_deatils);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadingDialog = new LoadingDialog(HeroDeatilsActivity.this);
        HeroesViewModel heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel.class);
        loadingDialog.startLoadingDialog();

        heroesViewModel.getHeroList().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                if(heroList != null && heroList.size() > 0 ){
                    loadingDialog.dismissDialog();
                    adapter = new HeroesAdapter(HeroDeatilsActivity.this, heroList);
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(HeroDeatilsActivity.this,"Failded to fetch...",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
