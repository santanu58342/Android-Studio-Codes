package com.example.santanu.day9_2;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String LOCAL_BROADCAST_ACTION = "com.dev2qa.example.broadcast.activity.LOCAL_BROADCAST";

    public static final String LOCAL_BROADCAST_SOURCE = "LOCAL_BROADCAST_SOURCE";

    private LocalBroadcastManager localBroadcastManager = null;

    private LocalBroadcastReceiverOne receiverOne = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("App One. dev2qa.com - Local Broadcast Manager Example.");

        // Get local broadcast manager object.
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        // Create local broadcast receiver one.
        receiverOne = new LocalBroadcastReceiverOne();

        // Create intent filter, add filter action.
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LOCAL_BROADCAST_ACTION);

        // Register receiver one to local broadcast manager.
        localBroadcastManager.registerReceiver(receiverOne, intentFilter);
        //registerReceiver(receiverOne, intentFilter);

        Button sendBroadcastOneButton = (Button)findViewById(R.id.send_local_broadcast_one_button);
        sendBroadcastOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When being clicked, it will send a local broadcast with the sender info.
                Intent intent = new Intent(LOCAL_BROADCAST_ACTION);
                intent.putExtra(LOCAL_BROADCAST_SOURCE, "Activity One");
                localBroadcastManager.sendBroadcast(intent);
                //sendBroadcast(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(localBroadcastManager!=null)
        {
            // Do not forget unregister the local broadcast receiver in onDestroy method.
            localBroadcastManager.unregisterReceiver(receiverOne);
            //unregisterReceiver(receiverOne);
        }
    }
}