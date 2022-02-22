package com.company;

import java.util.Scanner;

public class Login {

    protected boolean logowanie(boolean end){
        String name;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Zaloguj się!");
        System.out.println("Podaj nazwe użytkownika.");
        name = sc.nextLine();
        if(name.equals("admin")){
            System.out.println("Podaj hasło.");
            password = sc.nextLine();
            if(password.equals("admin")){
                System.out.println("Zalogowano poprawnie.");
                end = true;
            }
            else {
                System.out.println("Błędne dane logowania.");
            }
        }
        else{
            System.out.println("Błędne dane logowania.");
        }
        return end;

    }
}
