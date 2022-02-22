package com.company;

import javax.swing.text.StyledEditorKit;
import java.util.Objects;
import java.util.Scanner;

public class Miejsce {
    String kto;
    int ktore;
    boolean okno;
    boolean czyZajete;
    Scanner scanner = new Scanner(System.in);

    public Miejsce(int i) {
       kto = "miejsce niezarezerwowane";
       czyZajete = false;
       ktore = i + 1;
       if (ktore % 3 == 0)
       {
           okno = true;
       }
       else
       {
           okno = false;
       }
    }

    Miejsce()
    {

    }

    public void rezerwacja()
    {
        if (czyZajete == true)
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Probojesz zarezerwowac zajete miejsce, usun wczesniej rezerwacje. ");
            System.out.println("-------------------------------------------------------------------");
        }
        else
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Podaj swoje imie, nazwisko oraz adres zamieszkania. ");
            System.out.println("-------------------------------------------------------------------");
            kto = scanner.nextLine();

            czyZajete = true;
        }
    }

    public void usunRezerwacje()
    {
        String x;
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Czy na pewno chcesz usunac rezerwacje? ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("[yes] - tak");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("[no] - nie");
        System.out.println("-------------------------------------------------------------------");

        if (czyZajete) {
            x = scanner.nextLine();
            if (Objects.equals(x, "yes")) {
                czyZajete = false;
                kto = "Miejsce niezarezerowane";

                System.out.println("-------------------------------------------------------------------");
                System.out.println("Rezerwacja zostala usunieta");
                System.out.println("-------------------------------------------------------------------");
            } else if (Objects.equals(x, "no")) {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Nie usunieto rezerwacji.");
                System.out.println("-------------------------------------------------------------------");
            } else {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Wpisz YES lub NO.");
                System.out.println("-------------------------------------------------------------------");
            }
        }
        else if(!czyZajete)
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Probojesz wybrac miejsce, ktore nie jest jeszcze zarezerwowane");
            System.out.println("-------------------------------------------------------------------");
        }
    }

    public void pokazZarezerowane()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println(kto);
        if(!okno)
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Miejsce bez okna.");
            System.out.println("-------------------------------------------------------------------");
        }
        else if(okno)
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Miejsce z oknem.");
            System.out.println("-------------------------------------------------------------------");
        }
    }

    public boolean czyZajete()
    {
        boolean dana = false;
        if(!czyZajete)
        {
            dana = false;
        }
        else if(czyZajete)
        {
            dana = true;
        }
        return dana;
    }

    public void nazwisko()
    {
        System.out.println(kto);
    }

}

