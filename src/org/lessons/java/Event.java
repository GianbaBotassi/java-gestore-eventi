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
        int originalBookeadSeats = bookedSeats;
        bookedSeats += seats;
        if(bookedSeats> totSeats){
            throw new IllegalArgumentException("Errore, sono disponibili solo :" + (totSeats - originalBookeadSeats) + " posti.");
        }
    }
    public void cancelEventSeats(int seats){
        int originalBookeadSeats = bookedSeats;
        bookedSeats -= seats;
        if(bookedSeats < 0){
            throw new IllegalArgumentException("Errore, ci sono solo: " + (totSeats - originalBookeadSeats) + " posti.");
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
