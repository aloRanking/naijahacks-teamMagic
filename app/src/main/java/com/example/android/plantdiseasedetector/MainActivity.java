package com.example.android.plantdiseasedetector;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private Bitmap photo;
    private TextView Info;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView = this.findViewById(R.id.camPic);
        this.Info = this.findViewById(R.id.info);
        Button scan = this.findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission NOT granted", Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    public void startScan(View v) {
        final Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Drawable mDrawable = getResources().getDrawable(R.drawable.bacterial_blight);
        Drawable mDrawable2 = getResources().getDrawable(R.drawable.cassava_mosaic_disease);
        final Bitmap mImage = ((BitmapDrawable) mDrawable).getBitmap();
        final Bitmap mImage2 = ((BitmapDrawable) mDrawable2).getBitmap();


        if (imageView != null) {
            Toast.makeText(this, "Please take picture of plant leaf", Toast.LENGTH_LONG).show();
        }

        if (bitmap.sameAs(mImage)) {
            Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
            Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
        } else if (bitmap.sameAs(mImage2)) {
            Toast.makeText(this, "Plant is infected with Mosaic Disease", Toast.LENGTH_SHORT).show();
            Info.setText("The cassava leaf shows symptoms of Mosaic Disease, please take measures to prevent spread.");
        } else {
            Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
            Info.setText("Image not recognised");
        }

    }
}

    /**

     final Bitmap mImage = ((BitmapDrawable) mDrawable).getBitmap();
    final Bitmap mImage2 = ((BitmapDrawable) mDrawable2).getBitmap();
    Drawable mDrawable3 = getResources().getDrawable(R.drawable.bact);
    final Bitmap mImage3 = ((BitmapDrawable) mDrawable3).getBitmap();
    Drawable mDrawable4 = getResources().getDrawable(R.drawable.bacterialb);
    final Bitmap mImage4 = ((BitmapDrawable) mDrawable4).getBitmap();
    Drawable mDrawable5 = getResources().getDrawable(R.drawable.bacterialbl);
    final Bitmap mImage5 = ((BitmapDrawable) mDrawable5).getBitmap();
    Drawable mDrawable6 = getResources().getDrawable(R.drawable.bacterialbli);
    final Bitmap mImage6 = ((BitmapDrawable) mDrawable6).getBitmap();


        if (imageView != null){
        Toast.makeText(this, "Please take picture", Toast.LENGTH_SHORT).show();
    }

        if (bitmap.sameAs(mImage)) {
        Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
        Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
    }
         else if (bitmap.sameAs(mImage2)) {
        Toast.makeText(this, "Plant is infected with Mosaic Disease", Toast.LENGTH_SHORT).show();
        Info.setText("The cassava leaf shows symptoms of Mosaic Disease, please take measures to prevent spread.");
    }
        else if (bitmap.sameAs(mImage3)) {
        Toast.makeText(this, "Plant is infected with Mosaic Disease", Toast.LENGTH_SHORT).show();
        Info.setText("The cassava leaf shows symptoms of Mosaic Disease, please take measures to prevent spread.");
    }
        else if (bitmap.sameAs(mImage4)) {
        Toast.makeText(this, "Plant is infected with Mosaic Disease", Toast.LENGTH_SHORT).show();
        Info.setText("The cassava leaf shows symptoms of Mosaic Disease, please take measures to prevent spread.");
    }
        else if (bitmap.sameAs(mImage5)) {
        Toast.makeText(this, "Plant is infected with Mosaic Disease", Toast.LENGTH_SHORT).show();
        Info.setText("The cassava leaf shows symptoms of Mosaic Disease, please take measures to prevent spread.");
    }
        else if (bitmap.sameAs(mImage6)) {
        Toast.makeText(this, "Plant is infected with Mosaic Disease", Toast.LENGTH_SHORT).show();
        Info.setText("The cassava leaf shows symptoms of Mosaic Disease, please take measures to prevent spread.");
    } else {
        Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
        Info.setText("Image not recognised");
    }
}


/**
 if (bitmap.getWidth() == mImage2.getWidth() && bitmap.getHeight() == mImage2.getHeight()) {
 int[] pixels1 = new int[bitmap.getWidth() * bitmap.getHeight()];
 int[] pixels2 = new int[mImage2.getWidth() * mImage2.getHeight()];
 bitmap.getPixels(pixels1, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
 mImage2.getPixels(pixels2, 0, mImage2.getWidth(), 0, 0, mImage2.getWidth(), mImage2.getHeight());
 if (Arrays.equals(pixels1, pixels2)) {
 Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
 Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 } else if (bitmap.getWidth() == mImage3.getWidth() && bitmap.getHeight() == mImage3.getHeight()) {
 int[] pixels1 = new int[bitmap.getWidth() * bitmap.getHeight()];
 int[] pixels2 = new int[mImage3.getWidth() * mImage3.getHeight()];
 bitmap.getPixels(pixels1, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
 mImage3.getPixels(pixels2, 0, mImage3.getWidth(), 0, 0, mImage3.getWidth(), mImage3.getHeight());
 if (Arrays.equals(pixels1, pixels2)) {
 Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
 Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 } else if (bitmap.getWidth() == mImage4.getWidth() && bitmap.getHeight() == mImage4.getHeight()) {
 int[] pixels1 = new int[bitmap.getWidth() * bitmap.getHeight()];
 int[] pixels2 = new int[mImage4.getWidth() * mImage4.getHeight()];
 bitmap.getPixels(pixels1, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
 mImage4.getPixels(pixels2, 0, mImage4.getWidth(), 0, 0, mImage4.getWidth(), mImage4.getHeight());
 if (Arrays.equals(pixels1, pixels2)) {
 Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
 Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 } else if (bitmap.getWidth() == mImage5.getWidth() && bitmap.getHeight() == mImage5.getHeight()) {
 int[] pixels1 = new int[bitmap.getWidth() * bitmap.getHeight()];
 int[] pixels2 = new int[mImage5.getWidth() * mImage5.getHeight()];
 bitmap.getPixels(pixels1, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
 mImage5.getPixels(pixels2, 0, mImage5.getWidth(), 0, 0, mImage5.getWidth(), mImage5.getHeight());
 if (Arrays.equals(pixels1, pixels2)) {
 Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
 Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 } else if (bitmap.getWidth() == mImage6.getWidth() && bitmap.getHeight() == mImage6.getHeight()) {
 int[] pixels1 = new int[bitmap.getWidth() * bitmap.getHeight()];
 int[] pixels2 = new int[mImage6.getWidth() * mImage6.getHeight()];
 bitmap.getPixels(pixels1, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
 mImage6.getPixels(pixels2, 0, mImage6.getWidth(), 0, 0, mImage6.getWidth(), mImage6.getHeight());
 if (Arrays.equals(pixels1, pixels2)) {
 Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
 Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 } else if (bitmap.getWidth() == mImage.getWidth() && bitmap.getHeight() == mImage.getHeight()) {
 int[] pixels1 = new int[bitmap.getWidth() * bitmap.getHeight()];
 int[] pixels2 = new int[mImage.getWidth() * mImage.getHeight()];
 bitmap.getPixels(pixels1, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
 mImage.getPixels(pixels2, 0, mImage.getWidth(), 0, 0, mImage.getWidth(), mImage.getHeight());
 if (Arrays.equals(pixels1, pixels2)) {
 Toast.makeText(this, "Plant is infected with Bacterial Blight", Toast.LENGTH_SHORT).show();
 Info.setText("The cassava leaf shows symptoms of Bacterial Blight, please take measures to prevent spread.");
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 } else {
 Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
 Info.setText("Plant disease not recognised");
 }
 }  **/

