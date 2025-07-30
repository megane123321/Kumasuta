package com.knct_ci4_2025.kumasuta.collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.knct_ci4_2025.kumasuta.DataBase;
import com.knct_ci4_2025.kumasuta.R;
import com.knct_ci4_2025.kumasuta.Reader.StampReadActivity;
import com.knct_ci4_2025.kumasuta.stamp.StampView;

public class CollectionActivity extends StampReadActivity {
    final static int COLLECTION_WID=2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.collection), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Insets motionArea=insets.getInsets(WindowInsetsCompat.Type.systemGestures());
            v.findViewById(R.id.collection_stamps).setPadding(motionArea.left,motionArea.top,motionArea.right,motionArea.bottom);
            return insets;
        });

        TableLayout collection=(TableLayout)findViewById(R.id.collection_stamps);
        int collection_hei=DataBase.STAMP_VAL/COLLECTION_WID;
        if(DataBase.STAMP_VAL%COLLECTION_WID!=0){
            collection_hei++;
        }
        for (int i = 0; i < collection_hei; i++) {
            TableLayout.LayoutParams line_layout=new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            line_layout.weight=1;
            line_layout.gravity= Gravity.CENTER_VERTICAL;
            TableRow stamp_card_line=new TableRow(getBaseContext());
            stamp_card_line.setLayoutParams(line_layout);
            collection.addView(stamp_card_line);
            for (int j = 0; j < COLLECTION_WID; j++) {
                TableRow.LayoutParams params=new TableRow.LayoutParams();
                params.weight=1;
                View stamp;
                if(i*COLLECTION_WID+j<DataBase.STAMP_VAL){
                    stamp=new CollectionStampView(getBaseContext());
                }else{
                    stamp=new View(getBaseContext());
                }
                stamp.setLayoutParams(params);
                stamp_card_line.addView(stamp);
            }
        }

        ImageButton backButton=(ImageButton) findViewById(R.id.back_form_collection);
        backButton.setOnClickListener((v)->{
            finish();
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        TableLayout collection=(TableLayout)findViewById(R.id.collection_stamps);
        int collection_hei=DataBase.STAMP_VAL/COLLECTION_WID;
        if(DataBase.STAMP_VAL%COLLECTION_WID!=0){
            collection_hei++;
        }
        for (int i = 0; i < collection_hei; i++) {
            TableRow line=(TableRow)collection.getChildAt(i);
            for (int j = 0; j < COLLECTION_WID; j++) {
                int index=i*COLLECTION_WID+j;
                if(index<DataBase.STAMP_VAL) {
                    if(DataBase.getUnlocked(index)||true) {
                        StampView view = (StampView) line.getChildAt(j);
                        view.setStamp(index+1);
                    }
                }else{
                    break;
                }
            }
        }
    }
}
