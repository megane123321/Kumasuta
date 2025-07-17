package com.knct_ci4_2025.kumasuta;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.knct_ci4_2025.kumasuta.stamp.*;
import com.knct_ci4_2025.kumasuta.stamp.StampView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stamp_card);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.stamp_home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ConstraintLayout view=(ConstraintLayout)findViewById(R.id.stamp_home);
        TableLayout stamp_card_view=(TableLayout)findViewById(R.id.stamp_card);
        for (int i = 0; i < StampCard.STAMP_CARD_HEI; i++) {
            TableLayout.LayoutParams line_layout=new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            line_layout.weight=1;
            TableRow stamp_card_line=new TableRow(getBaseContext());
            stamp_card_line.setLayoutParams(line_layout);
            stamp_card_view.addView(stamp_card_line);
            for (int j = 0; j < StampCard.STAMP_CARD_WID; j++) {
                TableRow.LayoutParams params=new TableRow.LayoutParams();
                params.weight=1;
                StampView stamp=new StampView(getBaseContext());
                stamp.setLayoutParams(params);
                stamp_card_line.addView(stamp);
            }
        }
        ImageButton collectionButton=(ImageButton) findViewById(R.id.collection_button);
        collectionButton.setOnClickListener((v)->{
            Intent intent=new Intent(getBaseContext(),StampDrawActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        ConstraintLayout view=(ConstraintLayout)findViewById(R.id.stamp_home);
        TableLayout stamp_card_view=(TableLayout)findViewById(R.id.stamp_card);
        for (int i = 0; i < StampCard.STAMP_CARD_HEI; i++) {
            TableRow stamp_card_line=(TableRow)stamp_card_view.getChildAt(i);
            for (int j = 0; j < StampCard.STAMP_CARD_WID; j++) {
                int index=i*StampCard.STAMP_CARD_WID+j;
                ((StampView)stamp_card_line.getChildAt(j)).setStamp(DataBase.card.getStamp(index));
            }
        }
        TextView stamp_num=(TextView)findViewById(R.id.stampNum);
        stamp_num.setText(String.format(getString(R.string.stamp_num),DataBase.card.getStampsNum()));
        setContentView(view);
    }
}