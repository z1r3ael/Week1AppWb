package com.example.android.week1appwb.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Locale;

public class ReceiverExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String locale = Locale.getDefault().getCountry();
        Toast.makeText(context, "Язык изменен на " + locale, Toast.LENGTH_LONG).show();
    }
}
