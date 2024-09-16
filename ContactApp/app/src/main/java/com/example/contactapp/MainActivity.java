package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    String number;
    GridView gvId;
    TextView tvN;

    HashMap <String, String> hashMap = new HashMap<>();
    ArrayList< HashMap <String, String> >arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvId = findViewById(R.id.gvId);
        tvN = findViewById(R.id.tvNumber);

        hashMap = new HashMap<>();
        hashMap.put("name", "বিডি ফুড");
        hashMap.put("mobile", "01755359997");
        hashMap.put("des", "মাসুদ");
        hashMap.put("per", ""+ R.drawable.aaaa);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "অলিম্পিক");
        hashMap.put("mobile", "01987339293");
        hashMap.put("des", "সাইদুল ইসলাম");
        hashMap.put("per", ""+ R.drawable.aaaa);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+ R.drawable.aaaa);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "পুস্টি");
        hashMap.put("mobile", "01774173807");
        hashMap.put("des", "হাসান ভাই");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Dr. Rafiqul Islam");
        hashMap.put("mobile", "01738341882");
        hashMap.put("des", "Sylhet");
        hashMap.put("per", ""+R.drawable.e);
        arrayList.add(hashMap);



        MyAdapter myAdapter = new MyAdapter();
        gvId.setAdapter(myAdapter);


    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mView = layoutInflater.inflate(R.layout.item, viewGroup, false);


            ImageView callImg = mView.findViewById(R.id.callId);
            ImageView person = mView.findViewById(R.id.personImgId);
            TextView tvN = mView.findViewById(R.id.tvNumber);
            TextView Name = mView.findViewById(R.id.tvName);
            TextView Des = mView.findViewById(R.id.tvDes);

            HashMap<String, String> hashMap = arrayList.get(i);
            tvN.setText(hashMap.get("mobile"));
            Name.setText(hashMap.get("name"));
            Des.setText(hashMap.get("des"));
            String per = hashMap.get("per");

            int p = Integer.parseInt(per);
            person.setImageResource(p);



            callImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    number = tvN.getText().toString();
                    makePhoneCall();
                }
            });




            return mView;
        }
    }
    private void makePhoneCall() {
        //String number = tvN.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


}