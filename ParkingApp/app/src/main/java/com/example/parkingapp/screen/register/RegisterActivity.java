package com.example.parkingapp.screen.register;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.parkingapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private String username = "";
    private String password = "";
    private String repeatPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Register");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initRegisterButton();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getParentActivityIntent() == null) {
                onBackPressed();
            } else {
                NavUtils.navigateUpFromSameTask(this);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBinding() {
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void initRegisterButton() {
        binding.registerButton.setOnClickListener(v -> checkInputFields());
    }

    private void checkInputFields() {
        getUserInput();
        if (!username.isEmpty() && !password.isEmpty() && !repeatPassword.isEmpty()) {
            if (isPasswordMatch()) {
                //TODO add User in to DB
                // If success get back to login
                Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Password not match, try again", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "All input fields must be filled", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUserInput() {
        username = binding.usernameInput.getText().toString();
        password = binding.passwordInput.getText().toString();
        repeatPassword = binding.repeatPasswordInput.getText().toString();
    }

    private boolean isPasswordMatch() {
        return binding.passwordInput.getText().toString().equals(binding.repeatPasswordInput.getText().toString());
    }
}