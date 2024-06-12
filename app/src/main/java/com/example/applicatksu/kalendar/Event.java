package com.example.applicatksu.kalendar;

public class Event {
    private String date;
    private String eventName;

    // Конструктор
    public Event(String date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    // Геттеры и сеттеры
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // Переопределение метода toString для отображения данных в ListView
    @Override
    public String toString() {
        return date + " - " + eventName;
    }
}

