package com.example.tattoostudioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView photoRecyclerview1;
    private LinearLayoutManager linearLayoutManager;
    private Button viewAllBtn;
    private TextView imageTxt,backBtn;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        photoRecyclerview1 = findViewById(R.id.recyclerView1);
        viewAllBtn = findViewById(R.id.viewallBtn);
        imageTxt = findViewById(R.id.imageSizeText);
        backBtn = findViewById(R.id.backBtn);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        photoRecyclerview1.setLayoutManager(linearLayoutManager);

        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.photoa));
        photos.add(new Photo(R.drawable.photob));
        photos.add(new Photo(R.drawable.photoa));
        photos.add(new Photo(R.drawable.photob));
        photos.add(new Photo(R.drawable.photoa));
        photos.add(new Photo(R.drawable.photob));
        photos.add(new Photo(R.drawable.photoa));
        photos.add(new Photo(R.drawable.photob));
        PhotoAdapter photoAdapter = new PhotoAdapter(photos);
        photoRecyclerview1.setAdapter(photoAdapter);
        photoAdapter.notifyDataSetChanged();

        imageTxt.setText(String.valueOf(photos.size()));

        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(GalleryActivity.this,R.anim.slide_in_bottom);
                startActivity(new Intent(GalleryActivity.this,ExpandGalleryActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GalleryActivity.this,BioActivity.class));
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(GalleryActivity.this,BioActivity.class));
    }

}