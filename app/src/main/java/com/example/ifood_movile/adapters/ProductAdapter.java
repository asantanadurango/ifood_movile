package com.example.ifood_movile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ifood_movile.databinding.ActivityItemListBinding;
import com.example.ifood_movile.entities.ProductEntity;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ActivityItemListBinding binding;
    private Context context;
    private ArrayList<ProductEntity> productArrayList;

    public ProductAdapter(Context context, ArrayList<ProductEntity> productArrayList){
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ActivityItemListBinding.inflate(LayoutInflater.from(context));
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        final int[] numberUnits = {1};
        ProductEntity productEntity = productArrayList.get(position);
        holder.itemListBinding.tvName.setText(productEntity.getName());
        holder.itemListBinding.tvPrice.setText(String.valueOf(productEntity.getPrice()));
        holder.itemListBinding.tvStock.setText(String.valueOf(numberUnits[0]));
        holder.itemListBinding.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numberUnits[0] += 1;
                holder.itemListBinding.tvStock.setText(String.valueOf(numberUnits[0]));
            }
        });
        holder.itemListBinding.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberUnits[0] -= 1;
                holder.itemListBinding.tvStock.setText(String.valueOf(numberUnits[0]));
            }
        });
        holder.itemListBinding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Añadido al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        // holder.itemListBinding.imageView
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ActivityItemListBinding itemListBinding;
        public ProductViewHolder(@NonNull ActivityItemListBinding itemListBinding) {
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
        }
    }
}
