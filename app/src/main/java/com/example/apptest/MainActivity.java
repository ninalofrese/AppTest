package com.example.apptest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.apptest.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText numero1EditText;
    private EditText numero2EditText;
    private EditText resultadoEditText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1EditText = findViewById(R.id.primeiro_numero_edit_text_id);
        numero2EditText = findViewById(R.id.segundo_numero_edit_text_id);
        resultadoEditText = findViewById(R.id.resultado_edit_text_id);
        calcularButton = findViewById(R.id.calcular_button_id);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        calcularButton.setOnClickListener(view ->
                mainViewModel.calcular(Integer.parseInt(numero1EditText.getEditableText().toString()), Integer.parseInt(numero2EditText.getEditableText().toString())));

        mainViewModel.getResultadoLiveData()
                .observe(this, resultado -> resultadoEditText.setText(String.valueOf(resultado)));

    }
}
