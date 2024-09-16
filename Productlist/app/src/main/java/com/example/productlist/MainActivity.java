package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ProgressBar pb;
    ListView lv;

    HashMap<String, String> hashMap;
    ArrayList< HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        pb = findViewById(R.id.pb);



        String url = "https://munnavaritystore.000webhostapp.com/munna/info.json";
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int x=0; x<response.length(); x++){
                        JSONObject jsonObject = response.getJSONObject(x);
                        String name = jsonObject.getString("name");
                        String mobile = jsonObject.getString("poriman");
                        String email = jsonObject.getString("kenadam");
                        String location = jsonObject.getString("bechadam");
                        String homeTown = jsonObject.getString("mrp");

                        hashMap = new HashMap<>();
                        hashMap.put("name", name);
                        hashMap.put("poriman", mobile);
                        hashMap.put("kenadam", email);
                        hashMap.put("bechadam", location);
                        hashMap.put("mrp", homeTown);
                        arrayList.add(hashMap);

                    }
                    MyAdapter myAdapter = new MyAdapter();
                    lv.setAdapter(myAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(arrayRequest);


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

            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.item, null);

            TextView tv1 = myView.findViewById(R.id.tv1);
            TextView tv2 = myView.findViewById(R.id.tv2);
            TextView tv3 = myView.findViewById(R.id.tv3);
            TextView tv4 = myView.findViewById(R.id.tv4);
            TextView tv5 = myView.findViewById(R.id.tv5);

            HashMap< String, String> hashMap = arrayList.get(i);

            String name = hashMap.get("name");
            String poriman = hashMap.get("poriman");
            String kenadam = hashMap.get("kenadam");
            String bechadam = hashMap.get("bechadam");
            String mrp = hashMap.get("mrp");

            tv1.setText(name);
            tv2.setText(poriman);
            tv3.setText(kenadam);
            tv4.setText(bechadam);
            tv5.setText(mrp);
            return myView;

        }
    }

}