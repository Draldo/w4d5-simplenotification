package com.example.admin.notificationlifecycle;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private void showNotification(String title, int id){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle(title)
                        .setContentText("Hello");

        // Sets an ID for the notification
        int mNotificationId = id;
        NotificationManager mNotifyMgr =  (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNotification("onCreate Notification", 001);
    }

    @Override
    protected void onStop() {
        showNotification("onStop Notification", 005);
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        showNotification("onDestroy Notification", 006);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        showNotification("onPause Notification", 004);
        super.onPause();
    }

    @Override
    protected void onResume() {
        showNotification("onResume Notification", 003);
        super.onResume();
    }

    @Override
    protected void onStart() {
        showNotification("onStart Notification", 002);
        super.onStart();
    }
}
