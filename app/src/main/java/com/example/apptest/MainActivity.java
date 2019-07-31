package com.example.apptest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.apptest.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText alturaEditText;
    private EditText pesoEditText;
    private TextView resultadoTextView;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alturaEditText = findViewById(R.id.altura_edit_text_id);
        pesoEditText = findViewById(R.id.peso_edit_text_id);
        resultadoTextView = findViewById(R.id.resultado_text_id);
        calcularButton = findViewById(R.id.calcular_button_id);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        calcularButton.setOnClickListener(view ->
                mainViewModel.calcular(Float.parseFloat(alturaEditText.getEditableText().toString()), Float.parseFloat(pesoEditText.getEditableText().toString())));

        mainViewModel.getResultadoLiveData()
                .observe(this, resultado -> resultadoTextView.setText(String.valueOf(resultado)));

    }
}
