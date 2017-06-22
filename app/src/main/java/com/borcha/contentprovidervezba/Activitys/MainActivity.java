package com.borcha.contentprovidervezba.Activitys;


import android.content.ContentResolver;
import android.content.UriMatcher;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import com.borcha.contentprovidervezba.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public
    ContentResolver resolver;
    Spinner spSlike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spSlike=(Spinner)findViewById(R.id.spinner);

        resolver=getContentResolver();


        Cursor cursorInternal=resolver.query( MediaStore.Images.Media.INTERNAL_CONTENT_URI,null,null,null,null);
        Cursor cursorExternal=resolver.query( MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,null);

        SimpleCursorAdapter curAdapter=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item,cursorExternal,new String[]{MediaStore.Images.Media.DATA},new int[]{android.R.id.text1});

        //spSlike.setAdapter(curAdapter);

        //Varijanta iz assets-a
        ArrayAdapter<String> adFromAssets=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getFromAssets());

        spSlike.setAdapter(adFromAssets);


/*     Custom
       MyContentProvider myCont=new MyContentProvider();
        myCont.query(BorchaContract.Podaci.URI_FOLDER,null,null,null,null);*/



    }

    private ArrayList<String> getFromAssets() {

        String[] list=null;
         ArrayList<String> arLista=new ArrayList<>();

        try {
            list=getAssets().list("slike");  // ukoliko su slike u assets folderu a ne u nekom subfolderu staviti samo znake navoda -prazne ili ime sub foldera .list("subfolder");
            for (String stavka : list ) {
                arLista.add(stavka);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arLista;
    }
}
