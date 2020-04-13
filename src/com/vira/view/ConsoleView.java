package com.vira.view;

import com.vira.perssistance.CatalogFromMemory;
import com.vira.service.PersonService;

import java.util.Scanner;

public class ConsoleView {

    public static void start() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        PersonService service = new PersonService(new CatalogFromMemory());
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("Chose options: "+" 1.Add Person  2.Display PErson  3.Display Oldest person   4.Display Youngest person  5.Exit"  );

            //catalog.birthday();
            int option = scanner.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Enter name :");
                    scanner.nextLine();
                    String name = (scanner.nextLine());

                    System.out.println("Enter email :");
                    String mail = (scanner.nextLine());

                    System.out.println("Enter name, email and date of birth(dd-mm-yyyy):");
                    String date = (scanner.nextLine());
                    service.addPerson(name,mail,date);
                    break;
                case 2:
                    service.displayPerson();
                    break;
                case 3:
                    System.out.println(service.getOldestPerson());
                    break;
                case 4:
                    System.out.println(service.getYoungestPerson());
                    break;
                case 5:
                    isRunning = false;

                    break;
            }
        }
    }
}

