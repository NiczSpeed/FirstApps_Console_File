package com.company;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        boolean koniec = true;
        boolean pop = false;
        double[] wydatkiWartosc = new double[1000];
        String[] wydatkiOpis = new String[1000];
        double[] przychodyWartosc = new double[1000];
        String[] przychodyOpis = new String[1000];
        double sumaWyd = 0;
        double sumaPrzych = 0;
        int tabWyd = 0;
        int tabPrzych = 0;

        File f = new File("rozliczenie.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("Utworzono plik.");
            } catch (Exception e) {
                System.out.println("Utworzenie pliku nie powiodło się!");
            }
        }
        Login log = new Login();

        while (!log.logowanie(pop)) {
            log.logowanie(pop);
        }


        do {
            if (f.canWrite()) {
                try {
                    FileWriter fw = new FileWriter(f,true);
                    Formatter fm = new Formatter(fw);
                    Scanner sf = new Scanner(f);
                    int x;
                    double suma;
                    String opis;
                    double wartosc;
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("[1] - Dodaj Wydatki.");
                    System.out.println("[2] - Dodaj Przychody.");
                    System.out.println("[3] - Wyświetl Wydatki (aktualnej sesji programu).");
                    System.out.println("[4] - Wyświetl Przychody (aktualnej sesji programu).");
                    System.out.println("[5] - Aktualny stan środków.");
                    System.out.println("[6] - kończenie pracy programu.");
                    System.out.println("-----------------------------------------------------------");
                    Scanner scanner = new Scanner(System.in);
                    Scanner sc = new Scanner(System.in);
                    x = scanner.nextInt();
                    try {
                        switch (x) {
                            case 1:
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Ile wydales?");
                                System.out.println("-----------------------------------------------------------");
                                wartosc = scanner.nextDouble();
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Na co wydałeś?");
                                System.out.println("-----------------------------------------------------------");
                                opis = sc.nextLine();
                                wydatkiOpis[tabWyd]=opis;
                                wydatkiWartosc[tabWyd] = wartosc;
                                sumaWyd = sumaWyd + wydatkiWartosc[tabWyd];
                                fm.format("Wydatki: \r\n");
                                fm.format(tabWyd+1 +". %f zł. - %s \r\n",wydatkiWartosc[tabWyd],wydatkiOpis[tabWyd]);
                                tabWyd++;
                                fm.close();
                                break;
                            case 2:
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Ile zarobiłeś?");
                                System.out.println("-----------------------------------------------------------");
                                wartosc = scanner.nextDouble();
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Z czego zarobiłeś?");
                                System.out.println("-----------------------------------------------------------");
                                opis = sc.nextLine();
                                przychodyOpis[tabPrzych]=opis;
                                przychodyWartosc[tabPrzych]=wartosc;
                                sumaPrzych = sumaPrzych + przychodyWartosc[tabPrzych];
                                fm.format("Zarobek: \r\n");
                                fm.format(tabWyd+1 +". %f zł. - %s \r\n",przychodyWartosc[tabPrzych],przychodyOpis[tabPrzych]);
                                tabPrzych++;
                                fm.close();
                                break;
                            case 3:
                                for (int i = 0; i < wydatkiWartosc.length; i++) {
                                    if (wydatkiWartosc[i] != 0) {
                                        System.out.println(wydatkiWartosc[i]+" zł - "+ wydatkiOpis[i]);
                                    }
                                }
                                break;
                            case 4:
                                for (int i = 0; i < przychodyWartosc.length; i++) {
                                    if (przychodyWartosc[i] != 0) {
                                        System.out.println(przychodyWartosc[i]+" zł - "+przychodyOpis[i]);
                                    }
                                }
                                break;

                            case 5:
                                suma = sumaPrzych-sumaWyd;
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Saldo aktualnej sesji programu to: " + suma + " zł");
                                System.out.println("-----------------------------------------------------------");
                                break;

                            case 6:
                                koniec = false;
                                break;
                            default:
                                System.out.println("Wybrano nie poprawną opcje menu, ponów wybór!");
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
            while (koniec);
             {
             System.out.println("Kończenie pracy programu.");

             }
    }



}

