package com.google.firebase.faisal.localchat.Service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class FireBaseServiceId extends FirebaseInstanceIdService {
    private static final String TAG = "FireBaseServiceId";
    public static String common = "";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String newToken = FirebaseInstanceId.getInstance().getToken();
        common = newToken ;

        Log.d(TAG, "onTokenRefresh: common " +common);

    }
}
