package com.polytechtours.events;

public class EventsFactory {
    public static  Event make_dated(Event event, int date){
        event.setDate(date);
        return event;
    }
}
