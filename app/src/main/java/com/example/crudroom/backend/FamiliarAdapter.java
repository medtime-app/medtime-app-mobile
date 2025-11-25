package com.example.medtimeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FamiliarAdapter extends RecyclerView.Adapter<FamiliarAdapter.FamiliarViewHolder> {

    private List<Familiar> familiarList;

    public FamiliarAdapter(List<Familiar> familiarList) {
        this.familiarList = familiarList;
    }

    @NonNull
    @Override
    public FamiliarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_familiar, parent, false);
        return new FamiliarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FamiliarViewHolder holder, int position) {
        Familiar familiar = familiarList.get(position);
        holder.familiarName.setText(familiar.getName());
        holder.familiarPhone.setText(familiar.getPhone());
    }

    @Override
    public int getItemCount() {
        return familiarList.size();
    }

    static class FamiliarViewHolder extends RecyclerView.ViewHolder {
        TextView familiarName;
        TextView familiarPhone;

        FamiliarViewHolder(View view) {
            super(view);
            familiarName = view.findViewById(R.id.familiar_name);
            familiarPhone = view.findViewById(R.id.familiar_phone);
        }
    }
}
