package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class ProgrammEvent {
    //Attributes
    private String title;
    private ArrayList<Event> events;

    //Constructor

    public ProgrammEvent(String title) {
        this.title = title;
        this.events = new ArrayList<Event>();
    }

    //Methods
    //Metodo per aggiungere evento
    public void addEvent(Event evento){
        events.add(evento);
    }
    //Metodo che stampa la lista degli eventi inseriti
    public void eventList(){
        events.forEach(evento -> {
            System.out.println(evento);
        });
    }
    //Ritorna totale eventi inseriti
    public int totEvents(){
        return events.size();
    }
    //Cancella tutti gli eventi
    public void clearEvents(){
        events.clear();
    }
    //Creo una lista ordinata delle chiavi e stampo a schermo in formato chiave - valore
    public void orderList(){
        Map<LocalDate, String> orderList = new TreeMap<>();
        for (Event evento:events
             ) {
            orderList.put(evento.getDate(),evento.getTitle());
        }
        for (Map.Entry<LocalDate,String> elemento: orderList.entrySet()
             ) {
            System.out.println(elemento.getKey() + " - " + elemento.getValue());
        }
    }

    //Getters and Setters

    public String getTitle() {
        return title;
    }


}
