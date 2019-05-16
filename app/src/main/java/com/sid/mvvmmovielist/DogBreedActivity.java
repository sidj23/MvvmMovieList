package com.sid.mvvmmovielist;


import android.os.Bundle;

import com.sid.mvvmmovielist.adapter.DogBreedAdapter;
import com.sid.mvvmmovielist.databinding.ActivityDogBreedBinding;
import com.sid.mvvmmovielist.model.DogBreed;
import com.sid.mvvmmovielist.viewmodel.ActivityViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DogBreedActivity extends AppCompatActivity {

    ActivityViewModel viewModel;
    DogBreedAdapter mDogAdapter;
    LinearLayoutManager linearLayoutManager;
    ActivityDogBreedBinding activityDogBreedBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_breed);
        setupBindings(savedInstanceState);
        setUp();
    }

    private void setupBindings(Bundle savedInstanceState) {
        activityDogBreedBinding = DataBindingUtil.setContentView(this,R.layout.activity_dog_breed);
        viewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);
        if(savedInstanceState == null){
            viewModel.init();
        }
        activityDogBreedBinding.setModel(viewModel);
    }

    private void setUp(){
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        activityDogBreedBinding.dogRecycler.setLayoutManager(linearLayoutManager);
        activityDogBreedBinding.dogRecycler.setItemAnimator(new DefaultItemAnimator());
        activityDogBreedBinding.dogRecycler.setAdapter(mDogAdapter);
    }
}
