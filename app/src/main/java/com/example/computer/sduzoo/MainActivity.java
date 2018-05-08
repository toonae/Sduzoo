package com.example.computer.sduzoo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.animal,R.drawable.bear,R.drawable.bird,R.drawable.chameleon,
            R.drawable.crocodile,R.drawable.giraffe,R.drawable.hippo,R.drawable.mongolia,R.drawable.pen,
            R.drawable.portrait,R.drawable.sea,R.drawable.snake,R.drawable.tiger,R.drawable.tigerstar,R.drawable.zebra};

    private String[] titleStrings, detailStrings,TitleString,DetailString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //ดึงค่าจาก XML ที่ไฟล์ my_content มาแสดงผล
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);
        TitleString = getResources().getStringArray(R.array.Title);
        DetailString = getResources().getStringArray(R.array.Detail);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, detailStrings);
        listView.setAdapter((ListAdapter) myAdapter);


        //เมื่อคลิกแต่ละ item ใน Listview จะเชื่อมโยงไปหน้า Detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("Title", titleStrings[i]);
                detailIntent.putExtra("Detail", detailStrings[i]);
                detailIntent.putExtra("Title",TitleString[i]);
                detailIntent.putExtra( "Detail",DetailString[i]);
                detailIntent.putExtra("Image", ints[i]);
                startActivity(detailIntent);
            }
        });

    }//end onCreate Method

    public void clickLink(View view) {
        Intent linkIntent = new Intent(Intent.ACTION_VIEW);
        linkIntent.setData(Uri.parse("https://www.dlt.go.th/th/"));
        startActivity(linkIntent);
    }//end clickLink Method

    public void clickAboutMe(View view) {
        Intent aboutmeIntent = new Intent(MainActivity.this, AboutMeActivity.class);
        startActivity(aboutmeIntent);
    }
}//end Class