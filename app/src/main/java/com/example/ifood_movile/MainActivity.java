package com.example.ifood_movile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ifood_movile.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
    }

    public void toLogin(View view){
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
        Toast.makeText(this, "On Login", Toast.LENGTH_SHORT).show();
    }

}