package com.example.medtimeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

    private List<Medication> medicationList;

    public MedicationAdapter(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_medication, parent, false);
        return new MedicationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        Medication medication = medicationList.get(position);
        holder.medicationName.setText(medication.getName());
        holder.medicationTime.setText(medication.getTime());

        holder.detailsButton.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, MedicationDetailActivity.class);
            intent.putExtra("medication", medication);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return medicationList.size();
    }

    static class MedicationViewHolder extends RecyclerView.ViewHolder {
        TextView medicationName;
        TextView medicationTime;
        Button detailsButton;

        MedicationViewHolder(View view) {
            super(view);
            medicationName = view.findViewById(R.id.medication_name);
            medicationTime = view.findViewById(R.id.medication_time);
            detailsButton = view.findViewById(R.id.details_button);
        }
    }
}
