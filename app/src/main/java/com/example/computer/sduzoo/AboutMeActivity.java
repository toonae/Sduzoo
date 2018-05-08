package com.example.computer.sduzoo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    public void clickBack(View view) {
        finish();
    }



    public void clickFacebook(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse("https://www.facebook.com/supanida.prebyut"));
        startActivity(fbIntent);

    }//end clickFacebook Method

    public void clickMobile(View view) {
        Intent mobileInent = new Intent(Intent.ACTION_DIAL);
        mobileInent.setData(Uri.parse("tel:084-867-5482"));
        startActivity(mobileInent);
    }

    public void clickMap(View view) {
        String lat = "13.776171";
        String lng = "100.510746";
        String label = "มหาวิทยาลัยสวนดุสิต";

        Uri location = Uri.parse("http://maps.google.com/maps?z=10&q=loc:"+lat+","+lng+"("+label+")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,location);
        //mapIntent.setPackage("com.google.android.app.maps");//บังคับว่าลิ้งmapเปิดเฉพาะgoogle mapเท่านั้น และใช้testในgenyไม่ได้
        startActivity(mapIntent);



    }
}//end Class