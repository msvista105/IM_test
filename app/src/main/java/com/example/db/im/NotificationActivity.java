package com.example.db.im;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Login Activity
 * */
public class NotificationActivity extends AppCompatActivity {
    private static final boolean DEBUG = true;
    private static final String TAG = "MainActivity_sxm";
    private Button mHeadsUp = null;
    private Button mHeadsUpPlus = null;
    private int mNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeadsUp = (Button)findViewById(R.id.heads_up_notif);
        mHeadsUpPlus = (Button)findViewById(R.id.heads_up_notif_plus);
        mHeadsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendHeadsUpNotification(false);
            }
        });
//        mHeadsUpPlus.setOnClickListener((view)->{sendHeadsUpNotification(true);});
        mHeadsUpPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendHeadsUpNotification(true);
            }
        });
    }

    private void sendHeadsUpNotification(boolean plus) {
        if(DEBUG) Log.d(TAG,"sendHeadsUpNotification");
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/png");
        Notification.Builder builder = new Notification.Builder(this)
                .setContentText("------heads up text--------")
                .setContentTitle("-----heads up title--------")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setFullScreenIntent(PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT),true);
        Notification n = builder.getNotification();
        nm.notify(plus?(R.id.heads_up_notif+mNum):R.id.heads_up_notif,n);
        if(plus) mNum++;
    }

}
