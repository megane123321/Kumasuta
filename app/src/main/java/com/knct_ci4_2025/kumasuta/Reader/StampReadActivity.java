package com.knct_ci4_2025.kumasuta.Reader;

import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.knct_ci4_2025.kumasuta.DataBase;
import com.knct_ci4_2025.kumasuta.R;
import com.knct_ci4_2025.kumasuta.collection.CollectionActivity;

import org.json.JSONObject;

import java.io.IOException;

public abstract class StampReadActivity extends AppCompatActivity implements NfcAdapter.ReaderCallback{

    public StampReadActivity(){
        super();
    }

    @Override
    public void onTagDiscovered(Tag tag){
        Ndef ndef=Ndef.get(tag);
        try {
            ndef.connect();
            NdefMessage result=ndef.getNdefMessage();
            ndef.close();
            if(new String(result.getRecords()[0].getPayload()).equals(getString(R.string.app_name))){
                JSONObject json=new JSONObject(new String(result.getRecords()[1].getPayload()));
                int stamp_id=json.getInt("stamp_id");
                DataBase.getCard().addStamp(stamp_id);
                Intent intent=new Intent(this,this.getClass());
                finish();
                startActivity(intent);
            }
            for(NdefRecord i:result.getRecords()) {
                String str=new String(i.getPayload());
                System.out.println(str);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }finally {
            try{
                ndef.close();
            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }
    }

    @Override
    protected void onNewIntent(@NonNull Intent intent){
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        NfcAdapter.getDefaultAdapter(this).enableReaderMode(this,this,NfcAdapter.FLAG_READER_NFC_A,null);
    }
}
