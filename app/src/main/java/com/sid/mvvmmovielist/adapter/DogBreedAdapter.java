package com.sid.mvvmmovielist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sid.mvvmmovielist.BaseViewHolder;
import com.sid.mvvmmovielist.model.DogBreed;
import com.sid.mvvmmovielist.viewmodel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

public class DogBreedAdapter extends RecyclerView.Adapter<DogBreedAdapter.GenericViewHolder> {


    private int layoutId;
    private List<String> breeds = new ArrayList<>();
    private ItemViewModel itemViewModel = new ItemViewModel();

    public DogBreedAdapter() {
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater,viewType,parent,false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(itemViewModel,position);
    }


    @Override
    public int getItemCount() {
        return breeds ==  null ? 0 : breeds.size();
    }

    public class GenericViewHolder extends RecyclerView.ViewHolder{

        ViewDataBinding binding;

        public GenericViewHolder(@NonNull ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }

        void bind(ItemViewModel viewModel, Integer position) {
            viewModel.setName(breeds.get(position));
            binding.setVariable(BR.viewmodel, viewModel);
            binding.executePendingBindings();
        }
    }

    public void addItems(List<String> blogList) {
        breeds.addAll(blogList);
        notifyDataSetChanged();
    }
}
