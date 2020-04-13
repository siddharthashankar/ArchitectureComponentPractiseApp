package com.sid.architecture.component.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Toast;


import com.sid.architecture.component.R;

public class LoadingDialog {
   private Activity activity;
   private AlertDialog alertDialog;
   private AlertDialog.Builder builder;

   public LoadingDialog(Activity myActivity){
      activity = myActivity;
      builder = new AlertDialog.Builder(activity);
   }

   public void startLoadingDialog(){
       LayoutInflater inflater = activity.getLayoutInflater();
       builder.setView(inflater.inflate(R.layout.custom_dialog,null));
       builder.setCancelable(true);
       alertDialog = builder.create();
       alertDialog.show();
   }

   public void dismissDialog(){
       alertDialog.dismiss();
   }
}
