package com.example.ifood_movile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ifood_movile.adapters.ProductAdapter;
import com.example.ifood_movile.databinding.ActivityMainBinding;
import com.example.ifood_movile.entities.ProductEntity;
import com.example.ifood_movile.models.ProductModel;
import com.example.ifood_movile.services.ProductFeth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        getProducts();

    }

    public void toLogin(View view){
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
        Toast.makeText(this, "On Login", Toast.LENGTH_SHORT).show();
    }

    public void getProducts(){
        Retrofit retrofit = new Retrofit.Builder()
                //http://(ip de tu pc):8080/
                .baseUrl("http://Llocalhost:8080/").addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductFeth productFeth = retrofit.create(ProductFeth.class);
        Call<List<ProductModel>> call = productFeth.getProducts();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                List<ProductModel> productList = response.body();
                    for(ProductModel productModel: productList){
                        ProductEntity productEntity = new ProductEntity();
                        productEntity.setName(productModel.getName());
                        productEntity.setPrice(productModel.getPrice());
                        productEntity.setImgUrl(productModel.getImgUrl());
                        productArrayList.add(productEntity);
                    }
                productAdapter = new ProductAdapter(getApplicationContext(), productArrayList);
                binding.rvProducts.setHasFixedSize(true);
                binding.rvProducts.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                binding.rvProducts.setAdapter(productAdapter);
                    Log.d("TAG", "onResponse: " + productList.get(0).getName());

            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Log.d("TAG-Err", "onFailure: " + t.getMessage());
            }
        });
    }

}