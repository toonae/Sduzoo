package com.example.computer.sduzoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter1 extends BaseAdapter {
    //Explicit
    private Context context;
    private int[] ints;
    private String[]TitleString,DetailString;

    public MyAdapter1(Context context, int[] ints, String[] TitleStrings, String[] DetailStrings) {
        this.context = context;
        this.ints = ints;
        this.TitleString = TitleString;
        this.DetailString = DetailString;

    }

    @Override
    public int getCount() { //นับจำนวนข้อมูลใน Array แล้วส่งข้อมูลไปยัง Method getView()
        return ints.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {//รับข้อมูลจาก Method getCount() มาแสดงผลบนแอป

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = layoutInflater.inflate(R.layout.activity_detail, viewGroup, false);

        //ผูกตัวแปรบน JAVA กับอิลิเมนท์บน XML ที่หน้า my_listview
        TextView TitleTextView = view2.findViewById(R.id.txvTitle);
        TextView DetailTextView = view2.findViewById(R.id.txvDetail);
        ImageView imageView1 = view2.findViewById(R.id.imvSign);

        //Show data นำข้อมูลไปแสดงผลบนแอป
        imageView1.setImageResource(ints[i]);
        TitleTextView.setText(TitleString[i]);
        DetailTextView.setText(DetailString[i]);
        return view2;
    }
}//end Class