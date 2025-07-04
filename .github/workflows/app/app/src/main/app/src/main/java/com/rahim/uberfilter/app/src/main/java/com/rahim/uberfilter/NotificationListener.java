package com.rahim.uberfilter;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.os.Vibrator;
import android.content.Context;

public class NotificationListener extends NotificationListenerService {
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String text = sbn.getNotification().extras.getString("android.text");
        if (text != null && text.contains("Uber") && text.contains("€")) {
            String priceStr = text.replaceAll("[^0-9€]", "").replace("€", "");
            try {
                double price = Double.parseDouble(priceStr);
                if (price >= 10.0) {
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (v != null) v.vibrate(500);
                }
            } catch (Exception e) {}
        }
    }
}
