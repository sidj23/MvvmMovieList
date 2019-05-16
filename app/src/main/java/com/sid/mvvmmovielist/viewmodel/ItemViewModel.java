package com.sid.mvvmmovielist.viewmodel;


import com.sid.mvvmmovielist.model.DogBreed;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    private ObservableField<String> txtname = new ObservableField<>();

    public ItemViewModel() {
    }

    public void setName(String name) {
        txtname.set(name);
    }

    public ObservableField<String> getTxtname(){
        return txtname;
    }
}
