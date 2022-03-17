package com.example.ifood_movile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ifood_movile.databinding.ActivityItemListBinding;

public class ItemListActivity extends AppCompatActivity {

    ActivityItemListBinding binding;
    private int numberUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        numberUnits = 1;
        binding.tvStock.setText(String.valueOf(numberUnits));
    }

    public void increaseNumberUnits (View view){
        numberUnits += 1;
        binding.tvStock.setText(String.valueOf(numberUnits));
    }

    public void decreaseNumberUnits (View view){
        numberUnits -= 1;
        binding.tvStock.setText(String.valueOf(numberUnits));
    }

    public void addItem (View view){
        Toast.makeText(this, numberUnits + " Item added", Toast.LENGTH_SHORT).show();
    }
}