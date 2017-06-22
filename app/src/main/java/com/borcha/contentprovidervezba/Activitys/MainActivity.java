package com.borcha.contentprovidervezba.Activitys;


import android.content.ContentResolver;
import android.content.UriMatcher;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import com.borcha.contentprovidervezba.R;

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

        spSlike.setAdapter(curAdapter);


/*     Custom
       MyContentProvider myCont=new MyContentProvider();
        myCont.query(BorchaContract.Podaci.URI_FOLDER,null,null,null,null);*/



    }
}
