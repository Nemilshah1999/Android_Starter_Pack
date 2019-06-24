package com.example.nehaudeshi.imageeffects;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    Drawable myFlower;
    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView = (ImageView) findViewById(R.id.myImageView);

      myFlower = ResourcesCompat.getDrawable(getResources(), R.drawable.image, null);
        bitmapImage = ((BitmapDrawable) myFlower).getBitmap();

        Bitmap newphoto = invertImage(bitmapImage);
        myImageView.setImageBitmap(newphoto);

        /*
      // Adding layers for the image and filters
      Drawable [] layers = new Drawable[2];

      layers[0] = ResourcesCompat.getDrawable(getResources(), R.drawable.image, null);
      layers[1] = ResourcesCompat.getDrawable(getResources(), R.drawable.filter, null);

       The above code can also be written as:-

       layers[0] = getResources().getDrawable(R.drawable.image);
       layers[1] = getResources().getDrawable(R.drawable.filter);


        LayerDrawable layerDrawable = new LayerDrawable(layers);
        myImageView.setImageDrawable(layerDrawable);
         */
    }

    // Function for inverting the image
    public static Bitmap invertImage(Bitmap original){

        // Creating bitmap of final image
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());

        // Making some variables
        int A,R,G,B;
        int pixelcolor;
        int height = original.getHeight();
        int width = original.getWidth();

        // Inverting each pixel row-wise and column-wise
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                pixelcolor = original.getPixel(x,y);
                A = Color.alpha(pixelcolor);
                R = 255 - Color.red(pixelcolor);
                G = 255 - Color.green(pixelcolor);
                B = 255 - Color.blue(pixelcolor);

                finalImage.setPixel(x,y,Color.argb(A,R,G,B));
            }
        }
        return finalImage;

    }
}