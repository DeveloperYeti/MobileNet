package kr.ac.kopo.mobilenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;


public class GalleryActivity extends AppCompatActivity {

    public static final String TAG = "[IC]GalleryActivity";
    public static final int GALLERY_IMAGE_REQUEST_CODE = 1;
    private ClassifierWithModel cls;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_gallery));

        Button selectBtn =  findViewById(R.id.selectBtn);
        selectBtn.setOnClickListener(v -> getImageFromGallery());

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        cls = new ClassifierWithModel(this);
        try {
            cls.init();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        };
    private  void getImageFromGallery(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
//      Intent intent - new Intent(Intent.ACTION_PICK,
//      MediaStore.Images.Media.INTERNAL_CONTENT_RUL)
        startActivityForResult(intent,GALLERY_IMAGE_REQUEST_CODE);
    }




    }
