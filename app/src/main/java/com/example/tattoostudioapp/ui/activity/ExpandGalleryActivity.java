package com.example.tattoostudioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpandGalleryActivity extends AppCompatActivity {
    private RecyclerView fullBodyRecyclerView,realisticRecyclerview,symbolicRecyclerview;
    private LinearLayoutManager linearLayoutManager,linearLayoutManager1,linearLayoutManager2;
    private TextView imageTxt,backBtn,fullbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_gallery);

        fullBodyRecyclerView = findViewById(R.id.fullBodyRecyclerView);
        realisticRecyclerview = findViewById(R.id.photoRealRecyclerView);
        symbolicRecyclerview = findViewById(R.id.symbolicRecyclerview);
        imageTxt = findViewById(R.id.imageSizeText);
        backBtn = findViewById(R.id.backBtn);
        fullbtn = findViewById(R.id.fullbodyClick);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        linearLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);

        linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);

        fullBodyRecyclerView.setLayoutManager(linearLayoutManager);
        realisticRecyclerview.setLayoutManager(linearLayoutManager1);
        symbolicRecyclerview.setLayoutManager(linearLayoutManager2);


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

        fullBodyRecyclerView.setAdapter(photoAdapter);
        realisticRecyclerview.setAdapter(photoAdapter);
        symbolicRecyclerview.setAdapter(photoAdapter);
        photoAdapter.notifyDataSetChanged();

        imageTxt.setText(String.valueOf(photos.size()*3));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandGalleryActivity.this,GalleryActivity.class));
            }
        });

        fullbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpandGalleryActivity.this,ImageSwipeActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ExpandGalleryActivity.this,GalleryActivity.class));
    }
}