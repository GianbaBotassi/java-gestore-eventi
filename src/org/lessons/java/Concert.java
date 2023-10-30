package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    //Attributes
    private LocalTime time;
    private BigDecimal price;

    //Constructor


    public Concert(String title, LocalDate date, int totSeats, LocalTime time, BigDecimal price) {
        super(title, date, totSeats);
        this.time = time;
        this.price = price;
    }

    //Methods

    @Override
    public String toString() {
        return getFormattedDate() + " " + getFormattedTime() + " - " + getTitle() + " - " + getFormattedPrice() + " €.";
    }


    //Getters and Setters

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //Utility methods
    public String getFormattedTime(){
        return time.format(DateTimeFormatter.ISO_TIME);
    }
    public String getFormattedPrice(){
        DecimalFormat priceFormat = new DecimalFormat("##.00");
        return priceFormat.format(price);
    }
}
