package com.sid.architecture.component.livedata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.sid.architecture.component.livedata.model.Hero;
import com.sid.architecture.component.livedata.service.HeroListRepository;
import java.util.List;

public class HeroesViewModel extends AndroidViewModel {
  private HeroListRepository heroListRepository;

    public HeroesViewModel(@NonNull Application application) {
        super(application);
        heroListRepository = new HeroListRepository(application);
    }

    public LiveData<List<Hero>> getHeroList(){
        return heroListRepository.getMutableLiveData();
  }
}



