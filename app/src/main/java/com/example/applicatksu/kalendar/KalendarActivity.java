package com.example.applicatksu.kalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.applicatksu.R;

import java.util.ArrayList;
import java.util.Calendar;


public class KalendarActivity extends AppCompatActivity {
    private CalendarView calendarView;
    ListView listView;
    String eventName;
    ArrayList<Event> eventsList;
    ArrayAdapter<Event> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendar);

        calendarView = findViewById(R.id.calendarView);
        listView = findViewById(R.id.eventsListView);

        eventsList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventsList);
        listView.setAdapter(adapter);

        calendarView.setDate(System.currentTimeMillis(), false, true);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                Calendar seletDate = Calendar.getInstance();
                seletDate.set(year, month, dayOfMonth);

                String formattedDate = String.format("%02d.%02d.%d", dayOfMonth, (month + 1), year);

                AlertDialog.Builder builder = new AlertDialog.Builder(KalendarActivity.this);
                builder.setTitle("Введите название мероприятия");

                // Добавление поля ввода
                final EditText input = new EditText(KalendarActivity.this);
                builder.setView(input);

                // Добавление кнопок
                builder.setPositiveButton("OK", (dialog, which) -> {
                    eventName = input.getText().toString();
                    if (!eventName.isEmpty()) {
                        Event newEvent = new Event(formattedDate, eventName);
                        // Проверка на уникальность даты
                        boolean isUnique = true;
                        for (Event event : eventsList) {
                            if (event.getDate().equals(formattedDate)) {
                                isUnique = false;
                                break;
                            }
                        }
                        if (isUnique) {
                            eventsList.add(newEvent);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
                builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

                builder.show();

                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event selectedEvent = eventsList.get(position);
                String[] dateParts = selectedEvent.getDate().split("\\."); // Разделяем строку на части
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]) - 1; // Месяц начинается с 0
                int year = Integer.parseInt(dateParts[2]);

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                calendarView.setDate(calendar.getTimeInMillis()); // Устанавливаем дату в CalendarView
            }
        });

    }
    private void setReminder(Event event) {
        // Создание Intent для активации ReminderBroadcast
        Intent intent = new Intent(this, ReminderBroadcast.class);
        intent.putExtra("eventDate", event.getDate());
        intent.putExtra("eventName", event.getEventName());

        // Создание PendingIntent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Получение AlarmManager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Установка одноразового напоминания, которое сработает через 24 часа
        long triggerTime = SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_DAY;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent);
    }
}