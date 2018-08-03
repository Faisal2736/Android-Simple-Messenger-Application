package com.google.firebase.faisal.localchat.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.faisal.localchat.MainActivity;
import com.google.firebase.faisal.localchat.R;

public class FireBaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FireBaseMessagingServic";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        notificationReceived(remoteMessage.getNotification());
    }


    private void notificationReceived(RemoteMessage.Notification notification) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder  builder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher).
                setContentText(notification.getBody()).setContentTitle(notification.getTitle()).setAutoCancel(true).setContentIntent(pendingIntent);

        NotificationManager  notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());


    }



}
