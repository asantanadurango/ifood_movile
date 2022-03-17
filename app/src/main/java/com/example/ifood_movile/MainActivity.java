package com.example.ifood_movile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ifood_movile.adapters.ProductAdapter;
import com.example.ifood_movile.databinding.ActivityMainBinding;
import com.example.ifood_movile.entiies.ProductEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<ProductEntity> productArrayList;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        productArrayList = new ArrayList<>();

        //
            ProductEntity pr1 = new ProductEntity();
            pr1.setName("Manzana");
            pr1.setPrice(3000);
            productArrayList.add(pr1);
        //

        productAdapter = new ProductAdapter(this, productArrayList);
        binding.rvProducts.setHasFixedSize(true);
        binding.rvProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.rvProducts.setAdapter(productAdapter);
    }

    public void toLogin(View view){
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
        Toast.makeText(this, "On Login", Toast.LENGTH_SHORT).show();
    }

}