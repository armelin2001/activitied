package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {
    int selectedImage = 0;
    ImageView imageViewGallery;
    TextView imageName;
    TextView textViewCounter;
    String images [] = new String[]{"bob","patrick","lula","meme"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        imageViewGallery = findViewById(R.id.imageViewGallery);
        imageName = findViewById(R.id.imageName);
        textViewCounter = findViewById(R.id.textViewCounter);
        textViewCounter.setText(0+"/"+images.length);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String aux = extras.getString("data");
            setTitle(getString(R.string.galery_title)+" - "+aux);
        }
    }
    public void goNextImage(View view){
        if(selectedImage >= images.length || selectedImage < 0){
            selectedImage = 0;
        }

        Drawable drawable = getResources().getDrawable(
                getResources().getIdentifier(images[selectedImage],"drawable",
                        getPackageName()),this.getTheme());
        imageName.setText(images[selectedImage]);
        textViewCounter.setText(selectedImage+"/"+images.length);
        imageViewGallery.setImageDrawable(drawable);

        selectedImage ++;
    }
    public void goPreviousImage(View view){
        if(selectedImage >= images.length || selectedImage < 0){
            selectedImage = images.length - 1;
        }
        textViewCounter.setText(selectedImage+"/"+images.length);
        Drawable drawable = getResources().getDrawable(
                getResources().getIdentifier(images[selectedImage],"drawable",
                        getPackageName()),this.getTheme());
        imageName.setText(images[selectedImage]);

        imageViewGallery.setImageDrawable(drawable);
        selectedImage --;
    }
}