package com.example.crudroom.backend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddFamiliarActivity extends AppCompatActivity {

    private EditText editTextFamiliarNome;
    private EditText editTextFamiliarTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_familiar);

        editTextFamiliarNome = findViewById(R.id.edit_text_familiar_nome);
        editTextFamiliarTelefone = findViewById(R.id.edit_text_familiar_telefone);
        Button buttonSalvar = findViewById(R.id.button_salvar_familiar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextFamiliarNome.getText().toString();
                String phone = editTextFamiliarTelefone.getText().toString();

                if (!name.isEmpty() && !phone.isEmpty()) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("familiar", new Familiar(name, phone));
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
