package com.example.santanu.day10_3;
import android.app.Notification;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
public class MainActivity extends Activity {
    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.notBuilder = new NotificationCompat.Builder(this);
        // The message will automatically be canceled when the user clicks on Panel
        this.notBuilder.setAutoCancel(true);
    }
    public void notiButtonClicked(View view)  {
        // --------------------------
        // Prepare a notification
        // --------------------------
        this.notBuilder.setSmallIcon(R.mipmap.ic_launcher);
        this.notBuilder.setTicker("This is a ticker");
        // Set the time that the event occurred.
        // Notifications in the panel are sorted by this time.
        this.notBuilder.setWhen(System.currentTimeMillis()+ 10* 1000);
        this.notBuilder.setContentTitle("This is title");
        this.notBuilder.setContentText("This is content text ....");
        // Create Intent
        Intent intent = new Intent(this, MainActivity.class);
        // PendingIntent.getActivity(..) will start an Activity, and returns PendingIntent object.
        // It is equivalent to calling Context.startActivity(Intent).
        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        this.notBuilder.setContentIntent(pendingIntent);
        // Get a notification service (A service available on the system).
        NotificationManager notificationService =(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        // Builds notification and issue it
        Notification notification =  notBuilder.build();
        notificationService.notify(MY_NOTIFICATION_ID, notification);
    }
}