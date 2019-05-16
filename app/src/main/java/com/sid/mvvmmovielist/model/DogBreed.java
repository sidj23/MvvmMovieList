package com.sid.mvvmmovielist.model;

import androidx.databinding.BaseObservable;

public class DogBreed extends BaseObservable {

    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


}
