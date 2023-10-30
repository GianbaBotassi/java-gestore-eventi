package org.lessons.java;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event evento = null;
        boolean flagExit = false;

        System.out.println("Benvenuto nella creazione eventi.");

        System.out.println("""
                Digita:
                1 - Inserisci evento
                2 - Esci e stampa la lista Eventi""");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":

                try {
                    System.out.print("Inserisci il titolo dell'evento: ");
                    String title = scanner.nextLine();
                    System.out.print("Inserisci l'anno dell'evento: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inserisci il mese dell'evento: ");
                    int month = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inserisci il giorno dell'evento: ");
                    int day = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inserisci i posti totali: ");
                    int totSeats = Integer.parseInt(scanner.nextLine());

                    evento = new Event(title, LocalDate.of(year, month, day), totSeats);
                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (DateTimeException e) {
                    System.out.println("Invalido formato data");
                }
            case "2":
                break;
            default:
                System.out.println("Invalida scelta.");
        }
        if (evento != null) {

            while (!flagExit) {
                System.out.println("""
                        Quale operazione vuoi eseguire?
                        1 - Prenota dei posti
                        2 - Disdici dei posti
                        3 - Esci""");
                String choice2 = scanner.nextLine();
                switch (choice2) {
                    case "1":
                        try {
                            System.out.print("Quanti posti vuoi prenotare: ");
                            int bookSeats = Integer.parseInt(scanner.nextLine());
                            evento.book(bookSeats);
                            System.out.println("Posti prenotati: " + evento.getBookedSeates() + "\n" +
                                    "Posti disponibili: " + (evento.getTotSeates() - evento.getBookedSeates()));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "2":
                        try {
                            System.out.print("Quanti posti vuoi disdire: ");
                            int cancelSeats = Integer.parseInt(scanner.nextLine());
                            evento.cancelEventSeats(cancelSeats);
                            System.out.println("Posti prenotati: " + evento.getBookedSeates() + "\n" +
                                    "Posti disponibili: " + (evento.getTotSeates() - evento.getBookedSeates()));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "3":
                        flagExit = true;
                        System.out.println("Arrivederci");
                        break;
                    default:
                        System.out.println("Invalida scelta");
                        break;
                }
            }
        }
        scanner.close();
    }
}
