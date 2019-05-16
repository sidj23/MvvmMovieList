package com.sid.mvvmmovielist.utils;

import com.sid.mvvmmovielist.adapter.DogBreedAdapter;
import com.sid.mvvmmovielist.model.DogBreed;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class DataBinding {

    public DataBinding() {
    }

    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, List<String> blogs) {
        DogBreedAdapter adapter = (DogBreedAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addItems(blogs);
        }
    }
}
