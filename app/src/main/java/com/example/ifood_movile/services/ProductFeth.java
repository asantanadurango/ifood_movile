package com.example.ifood_movile.services;

import com.example.ifood_movile.models.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductFeth {

    @GET("products")
    Call<List<ProductModel>> getProducts();
}
