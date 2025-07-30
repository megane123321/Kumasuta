package com.knct_ci4_2025.kumasuta.Reader;

import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.NfcA;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.knct_ci4_2025.kumasuta.R;

import java.io.IOException;

public abstract class StampReadActivity extends AppCompatActivity implements NfcAdapter.ReaderCallback{

    public StampReadActivity(){
        super();
    }

    private NfcAdapter nfcAdapter;

    @Override
    public void onTagDiscovered(Tag tag){
        System.out.println(getString(R.string.app_name));
        NfcA nfcA=NfcA.get(tag);
        try {
            nfcA.connect();
            byte[] result = nfcA.transceive(new byte[nfcA.getMaxTransceiveLength()]);
            for(byte tmp:result){
                System.out.println(tmp);
            }
            nfcA.close();
        } catch (IOException e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }finally {
            try{
                nfcA.close();
            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }
//        try {
//            NdefMessage reader = new NdefMessage(tag.getId());
//            NdefRecord[] records=reader.getRecords();
//            for(NdefRecord tmp:records){
//                System.out.println(tmp.toMimeType());
//            }
//        }catch (FormatException e){
//            System.err.println(e+"\n正常に読み込めませんでした。");
//        }
    }

    @Override
    protected void onNewIntent(@NonNull Intent intent){
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        nfcAdapter=NfcAdapter.getDefaultAdapter(this);
        nfcAdapter.enableReaderMode(this,this,NfcAdapter.FLAG_READER_NFC_A,null);
    }
}
