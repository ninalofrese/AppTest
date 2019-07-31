package com.example.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.apptest.viewmodel.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;
    private TextInputLayout emailInputLayout;
    private TextInputLayout senhalInputLayout;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        emailEditText = findViewById(R.id.login_edit_text_id);
        senhaEditText = findViewById(R.id.senha_edit_text_id);
        okButton = findViewById(R.id.ok_button);
        emailInputLayout = findViewById(R.id.login_input_layout_id);
        senhalInputLayout = findViewById(R.id.senha_input_layout_id);

        okButton.setOnClickListener(view -> loginViewModel.login(emailEditText.getEditableText().toString(), senhaEditText.getEditableText().toString()));

        loginViewModel.getLoginLiveData()
                .observe(this, logged -> {
                    if (logged) {
                        goToMain();
                    } else {
                        emailEditText.setError("Login/senha inválido(s)");
                        senhaEditText.setError("Login/senha inválido(s)");
                    }
                });

    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
