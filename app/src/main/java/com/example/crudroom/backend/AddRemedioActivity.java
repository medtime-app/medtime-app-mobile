package com.example.medtimeapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddRemedioActivity extends AppCompatActivity {

    private EditText editTextRemedioNome;
    private EditText editTextRemedioDose;
    private EditText editTextRemedioTipo;
    private EditText editTextRemedioHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remedio);

        editTextRemedioNome = findViewById(R.id.edit_text_remedio_nome);
        editTextRemedioDose = findViewById(R.id.edit_text_remedio_dose);
        editTextRemedioTipo = findViewById(R.id.edit_text_remedio_tipo);
        editTextRemedioHorario = findViewById(R.id.edit_text_remedio_horario);
        Button buttonSalvar = findViewById(R.id.button_salvar);

        editTextRemedioHorario.setOnClickListener(v -> showTimePickerDialog());

        buttonSalvar.setOnClickListener(v -> {
            String name = editTextRemedioNome.getText().toString();
            String dose = editTextRemedioDose.getText().toString();
            String type = editTextRemedioTipo.getText().toString();
            String time = editTextRemedioHorario.getText().toString();

            if (!name.isEmpty() && !time.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("medication", new Medication(name, time, dose, type));
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        new TimePickerDialog(this,
                (view, hourOfDay, minuteOfHour) -> editTextRemedioHorario.setText(String.format("%02d:%02d", hourOfDay, minuteOfHour)),
                hour, minute, true).show();
    }
}
