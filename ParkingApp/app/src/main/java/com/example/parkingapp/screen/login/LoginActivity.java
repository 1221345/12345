package com.example.parkingapp.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingapp.databinding.ActivityLoginBinding;
import com.example.parkingapp.screen.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String username = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewBinding();
        initButtons();
    }

    private void initViewBinding() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void initButtons() {
        binding.register.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        binding.loginButton.setOnClickListener(v -> {
            getUserInput();

            if (!username.isEmpty() && !password.isEmpty()) {
                //TODO Check DB Entry
                //TODO If DB entry is ok, proceed to main screen
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "All input fields must be filled", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUserInput() {
        username = binding.username.getText().toString();
        password = binding.password.getText().toString();
    }
}