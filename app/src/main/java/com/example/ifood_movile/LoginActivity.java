package com.example.ifood_movile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ifood_movile.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void goToSignUp(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
        Toast.makeText(this, "On SignUp", Toast.LENGTH_SHORT).show();
    }

    public void goToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "On Main", Toast.LENGTH_SHORT).show();
    }
}