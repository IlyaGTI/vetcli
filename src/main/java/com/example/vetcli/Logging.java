package com.example.vetcli;

import java.util.Scanner;

public class Logging {
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "123";

    public static int login() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        System.out.print("Логин : ");
        String login = scanner.nextLine();
        System.out.print("Пароль : ");
        String password = scanner.nextLine();

        if(login.equals(LOGIN) && password.equals(PASSWORD)){
            check = true;
        }
        return check ? 19 : 0;
    }
}
