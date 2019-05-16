package com.sid.mvvmmovielist.viewmodel;

import android.util.Log;

import com.sid.mvvmmovielist.model.DogBreed;
import com.sid.mvvmmovielist.model.DogBreeds;
import com.sid.mvvmmovielist.net.Api;


import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityViewModel extends ViewModel {

    public List<String> dogbreed = new ArrayList<String>();

    private ObservableList<String> dogBreed;

    private String status;

    public void init() {
        fetchList();
    }

    public ObservableList<String> getBlogListLiveData() {
        return dogBreed;
    }

    public void fetchList() {
//        retrofit2.Callback<DogBreeds> callback = new Callback<DogBreeds>() {
//            @Override
//            public void onResponse(Call<DogBreeds> call, Response<DogBreeds> response) {
//
//                DogBreeds body = response.body();
//                status = body.status;
//                Log.d("status", "onResponse: "+body.getStatus());
//                dogBreed.addAll(body.breedList);
//            }
//            @Override
//            public void onFailure(Call<DogBreeds> call, Throwable t) {
//                Log.e("Test", t.getMessage(), t);
//            }
//        };
//
//        Api.getApi().getBreeds().enqueue(callback);
//    }
        dogbreed.add(0,"dbasjb");
        dogbreed.add(1,"lab");
        dogbreed.add(2,"don");
        dogbreed.add(3,"call");
        dogbreed.add(4,"fin");

        Log.d("do", "fetchList: ");

        dogBreed = new ObservableArrayList<>();
        dogBreed.addAll(dogbreed);
    }
}
