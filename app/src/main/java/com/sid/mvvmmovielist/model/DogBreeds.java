package com.sid.mvvmmovielist.model;

import android.util.Log;

import com.sid.mvvmmovielist.net.Api;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogBreeds extends BaseObservable {


    public String status;
    public List<DogBreed> breedList = new ArrayList<>();
    private MutableLiveData<List<DogBreed>> breeds = new MutableLiveData<>();

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void addBreed(DogBreed bd) {
        breedList.add(bd);
    }

    public List<DogBreed> getBreeds() {
        return breedList;
    }



    public void fetchList(){
        retrofit2.Callback<DogBreeds> callback = new Callback<DogBreeds>() {
            @Override
            public void onResponse(Call<DogBreeds> call, Response<DogBreeds> response) {

                DogBreeds body = response.body();
                status = body.status;
                Log.d("status", "onResponse: "+body.status);
                breeds.setValue(body.breedList);
            }
            @Override
            public void onFailure(Call<DogBreeds> call, Throwable t) {
                Log.e("Test", t.getMessage(), t);
            }
        };

        Api.getApi().getBreeds().enqueue(callback);
    }

}
