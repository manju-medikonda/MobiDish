package com.example.tataflycatalogue;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String[] spinnerarr = {"Telugu","English","Hindi"};
    String[] t = {"Star Maa","Gemini","Zee Telugu","ETV"};
    String[] e = {"Comedy Central","HBO","STAR MOVIES","MN+"};
    String[] h = {"Colors","Zee TV","Sony SAB","SET"};

    String[] tp = {"Star Maa                                        Rs. 9","Gemini                                           Rs. 7","Zee Telugu                                    Rs. 7","ETV                                                Rs. 8"};
    String[] ep = {"Comedy Central                          Rs. 19","HBO                                              Rs. 13","STAR MOVIES                             Rs. 9","MN+                                             Rs. 10"};
    String[] hp = {"Colors                                          Rs. 11","Zee TV                                         Rs. 10","Sony SAB                                     Rs. 12","SET                                               Rs. 13"};
    Button b1, b2,b3;
    Spinner sp;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.spinner);
        lv = findViewById(R.id.listview);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        ArrayAdapter ad = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,spinnerarr);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (Objects.equals(spinnerarr[i], "Telugu")){
                    ArrayAdapter adt = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.select_dialog_item_material,t);
                    lv.setAdapter(adt);
                }
                else if (Objects.equals(spinnerarr[i], "English")){
                    ArrayAdapter adt = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.select_dialog_item_material,e);
                    lv.setAdapter(adt);
                }
                else if (Objects.equals(spinnerarr[i], "Hindi")){
                    ArrayAdapter adt = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.select_dialog_item_material,h);
                    lv.setAdapter(adt);
                }

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Objects.equals(spinnerarr[i], "Telugu")) {
                            ArrayAdapter adt = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.select_dialog_item_material, tp);
                            lv.setAdapter(adt);
                        } else if (Objects.equals(spinnerarr[i], "English")) {
                            ArrayAdapter adt = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.select_dialog_item_material, ep);
                            lv.setAdapter(adt);
                        } else if (Objects.equals(spinnerarr[i], "Hindi")) {
                            ArrayAdapter adt = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.select_dialog_item_material, hp);
                            lv.setAdapter(adt);
                        }
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse("https://www.tataplay.com/explore/set-top-boxes-packs/dth-packages");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse("tel:18002086633");
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, uri);
                        startActivity(callIntent);
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}