package org.lessons.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Event scarpinocc = new Event("Sagra Scarpinocc", LocalDate.of(2024,8,22), 6);
        System.out.println(scarpinocc.toString());
        scarpinocc.book(6);
        System.out.println(scarpinocc.toString());
        scarpinocc.cancelEventSeats(5);
        System.out.println(scarpinocc.toString());
        System.out.println(scarpinocc.getDate());
    }
}
