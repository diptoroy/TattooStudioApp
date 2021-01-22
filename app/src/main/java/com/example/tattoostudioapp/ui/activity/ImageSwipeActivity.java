package com.example.tattoostudioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageSwipeActivity extends AppCompatActivity {

    private ViewPager photoViewPager;
    private TabLayout photoTabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private List<Photo> photos;
    private TextView pager,backMenu;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_swipe);

        photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.view));
        photos.add(new Photo(R.drawable.view));
        photos.add(new Photo(R.drawable.view));
        setViewPager(photos);
        backBtn = findViewById(R.id.backdBtn);
        backMenu = findViewById(R.id.backBtn);
        pager.setText(String.valueOf(photos.size() + " OF " + photos.size()));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageSwipeActivity.this,ExpandGalleryActivity.class));
            }
        });
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageSwipeActivity.this,ExpandGalleryActivity.class));
            }
        });
    }

    private void setViewPager(List<Photo> photo) {
        photoViewPager = findViewById(R.id.photoViewPager);
        photoTabLayout = findViewById(R.id.photoTabLayout);
        pager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(this, photo);
        photoViewPager.setAdapter(viewPagerAdapter);
        photoTabLayout.setupWithViewPager(photoViewPager);
        photoTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ImageSwipeActivity.this,ExpandGalleryActivity.class));
    }
}