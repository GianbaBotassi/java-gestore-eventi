package org.lessons.java;

import java.time.LocalDate;

public class Event {
    //Attribute
    private String title;
    private LocalDate date;
    private final int totSeats;
    private int bookedSeats;

    //Constructor
    public Event(String title, LocalDate date, int totSeats) {

        pastEvent(date);
        minTotSeates(totSeats);

        this.title = title;
        this.date = date;
        this.totSeats = totSeats;
        this.bookedSeats = 0;
    }

    //Methods


    @Override
    public String toString() {
        return date + " - " + title;
    }

    public void book(int seats){

        int wannaBookSeats = bookedSeats + seats;
        if(wannaBookSeats> totSeats){
            throw new IllegalArgumentException("Errore, sono disponibili solo " + (totSeats - bookedSeats) + " posti.");
        }else{
            bookedSeats += seats;
        }

    }
    public void cancelEventSeats(int seats){
        int wannaCancelSeats = bookedSeats - seats;
        if(wannaCancelSeats < 0){
            throw new IllegalArgumentException("Errore, ci sono " + bookedSeats + " posti prenotati.");
        }else{
            bookedSeats -= seats;
        }

    }


    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotSeates() {
        return totSeats;
    }

    public int getBookedSeates() {
        return bookedSeats;
    }

    //Utility Methods
    private void pastEvent(LocalDate date){
        if(date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data antecedente.");
        }

    }
    private void minTotSeates(int totSeats){
        if(totSeats <= 0){
            throw new IllegalArgumentException("I posti non possono essere minori o uguali a zero.");
        }
    }
}
