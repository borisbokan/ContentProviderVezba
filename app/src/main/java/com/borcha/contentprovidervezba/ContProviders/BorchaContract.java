package com.borcha.contentprovidervezba.ContProviders;

import android.net.Uri;

/**
 * Created by borcha on 22.06.17..
 */

public final class BorchaContract {


   public static final String AUTHORITY="com.borcha.ContProviders.MyContentProvider.podaci";
   public static final Uri URI_CONTENT=Uri.parse("content://" + AUTHORITY);



   public static final  class Podaci{

       public static final String FOLDER_NAME="assets";
       public static final String URI_MIMETYPE="image/jpeg";

       public static final Uri URI_FOLDER=Uri.parse(URI_CONTENT + "/" + FOLDER_NAME);



   }


}
