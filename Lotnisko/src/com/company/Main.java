package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Miejsce[] tab = new Miejsce[12];
        boolean end = true;

        for (int i = 0; i < 12; i++) {
            Miejsce Miejsce;
            tab[i] = Miejsce = new Miejsce(i);
        }

        int x;
        do
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("[1] - dodaj rezerwacje.");
            System.out.println("[2] - wyswietl dane o miejscu.");
            System.out.println("[3] - usun rezerwacje.");
            System.out.println("[4] - ile miejsc jest jeszcze wolnych.");
            System.out.println("[5] - lista wolnych miejsc.");
            System.out.println("[6] - lista rezerwacji.");
            System.out.println("[7] - koniec pracy programu.");
            System.out.println("-------------------------------------------------------------------");
            x = scanner.nextInt();
            if(x > 7 || x < 0)
            {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Niepoprawna dana!");
                System.out.println("-------------------------------------------------------------------");

                continue;
            }

            int wynik = 0;
            int nr;
            switch (x)
            {
                case 1:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Podaj numer miejsca, ktore chcesz zarezerwowac. [od 1 do 12]");
                    System.out.println("-------------------------------------------------------------------");
                    nr = scanner.nextInt();

                    if (nr <= 12 && nr > 0)
                    {
                        tab[nr - 1].rezerwacja();
                    }
                    else if (nr > 12 || nr <= 0)
                    {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("Niepoprawna dana, wracam do menu: ");
                        System.out.println("-------------------------------------------------------------------");
                    }

                    break;

                case 2:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Podaj numer miejsca, ktore chcesz wyswietlic. [od 1 do 12]");
                    System.out.println("-------------------------------------------------------------------");
                    nr = scanner.nextInt();
                    if (nr <= 12 && nr > 0)
                    {
                        tab[nr - 1].pokazZarezerowane();
                    }
                    else if (nr > 12 || nr <= 0)
                    {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("Niepoprawna dana, wracam do menu: ");
                        System.out.println("-------------------------------------------------------------------");
                    }

                    break;

                case 3:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Podaj numer miejsca, na ktore chcesz anulowac rezerwacje.[od 1 do 12]");
                    System.out.println("-------------------------------------------------------------------");
                    nr = scanner.nextInt();
                    if (nr <= 12 && nr > 0)
                    {
                        tab[nr - 1].usunRezerwacje();
                    }
                    else if (nr > 12 || nr <= 0)
                    {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("Niepoprawna dana, wracam do menu: ");
                        System.out.println("-------------------------------------------------------------------");
                    }

                    break;

                case 4:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Ile miejsc jest jeszcze pustych?");
                    System.out.println("-------------------------------------------------------------------");
                    for (int i = 0; i < 12; i++)
                    {
                        if (tab[i].czyZajete() == false)wynik++;
                    }
                    System.out.println("[" + wynik + "] - liczba wolnych miejsc.");

                    break;

                case 5:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Lista wolnych miejsc?");
                    System.out.println("-------------------------------------------------------------------");
                    for (int i = 0; i < 12; i++)
                    {
                        if (tab[i].czyZajete() == false)
                        {
                            System.out.print("[" + (i + 1) + "] - rezerwacja na: " );
                            tab[i].nazwisko();
                        }
                    }

                    break;

                case 6:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Zajete miejsca:");
                    System.out.println("-------------------------------------------------------------------");
                    for (int i = 0; i < 12; i++)
                    {
                        if (tab[i].czyZajete() == true)
                        {
                            System.out.print("[" + (i + 1) + "] - rezerwacja na: ");
                            tab[i].nazwisko();
                        }
                    }

                    break;

                case 7:
                    end = false;

                    break;

                default:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Error, cos nie dziala tak jak powinno!");
                    System.out.println("-------------------------------------------------------------------");
            }
        }
        while(end);
    }
}
