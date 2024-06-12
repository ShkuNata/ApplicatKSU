package com.example.applicatksu.kalendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

import com.example.applicatksu.R;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Получение названия события из Intent
        String eventName = intent.getStringExtra("eventName");
        // Предположим, что вы также передаете время события
        String eventDate = intent.getStringExtra("eventDate");

        // Создание канала уведомлений для Android 8.0 и выше
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Напоминание о событии";
            String description = "Канал для напоминаний о событиях";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyEvent", name, importance);
            channel.setDescription(description);
            // Регистрация канала в системе
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Создание уведомления
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyEvent")
                .setSmallIcon(R.drawable.logotipkgu)
                .setContentTitle("Напоминание о событии")
                .setContentText(eventDate + " " + eventName + " !")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Создание интента для запуска приложения по нажатию на уведомление
        Intent notificationIntent = new Intent(context, KalendarActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Отображение уведомления
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(200, builder.build());
    }
}
