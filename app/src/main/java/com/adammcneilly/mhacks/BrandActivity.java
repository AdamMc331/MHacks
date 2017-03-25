package com.adammcneilly.mhacks;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        // Create test list
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand("Apple", R.drawable.apple));
        brands.add(new Brand("Facebook", R.drawable.facebook));
        brands.add(new Brand("Google", R.drawable.google));
        brands.add(new Brand("Microsoft", R.drawable.microsoft));

        // Create adapter
        BrandAdapter adapter = new BrandAdapter(brands);

        // Create LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Get RecyclerView and set values
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.brand_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public class Brand {
        public String brandName;
        public int brandImage; // Resource id for drawable

        public Brand(String name, int image) {
            this.brandName = name;
            this.brandImage = image;
        }
    }

    public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {

        private List<Brand> brandList;

        public BrandAdapter(List<Brand> items) {
            this.brandList = items;
        }

        @Override
        public BrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create the list item view
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.list_item_brand, parent, false);
            // Create view holder
            return new BrandViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BrandViewHolder holder, int position) {
            Brand brand = brandList.get(position);
            holder.bindBrand(brand);
        }

        @Override
        public int getItemCount() {
            return brandList.size();
        }

        public class BrandViewHolder extends RecyclerView.ViewHolder {
            private ImageView brandImage;
            private TextView brandName;

            public BrandViewHolder(View view) {
                super(view);

                brandImage = (ImageView) view.findViewById(R.id.brand_image);
                brandName = (TextView) view.findViewById(R.id.brand_name);
            }

            public void bindBrand(Brand brand) {
                brandImage.setImageResource(brand.brandImage);
                brandName.setText(brand.brandName);
            }
        }
    }
}
