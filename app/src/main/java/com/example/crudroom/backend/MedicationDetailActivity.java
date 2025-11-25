package com.example.medtimeapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MedicationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_detail);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        Medication medication = (Medication) getIntent().getSerializableExtra("medication");

        if (medication != null) {
            TextView name = findViewById(R.id.detail_med_name);
            TextView dose = findViewById(R.id.detail_med_dose);
            TextView type = findViewById(R.id.detail_med_type);
            TextView time = findViewById(R.id.detail_med_time);

            name.setText(medication.getName());
            dose.setText("Dose: " + medication.getDose());
            type.setText("Tipo: " + medication.getType());
            time.setText("Horário: " + medication.getTime());
        }
    }
}
