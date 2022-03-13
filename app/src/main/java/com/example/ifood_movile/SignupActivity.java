package com.example.ifood_movile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ifood_movile.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void toRegister(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registered User", Toast.LENGTH_SHORT).show();
    }
}