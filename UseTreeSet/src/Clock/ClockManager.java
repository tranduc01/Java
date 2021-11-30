/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ClockManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClockList list = new ClockList();
        Menu menu = new Menu();
        menu.add("Add Clock");
        menu.add("Display All Clock");
        menu.add("Search Clock");
        menu.add("Quit");
        int choice = 0;
        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.output();
                    break;
                case 3:
                    System.out.println("Input id to search:");
                    String id = sc.nextLine();
                    Clock c = list.search(id);
                    if (c == null) {
                        System.out.println("Clock " + id + " does not exist");
                    } else {
                        System.out.println("Found: " + c);
                    }
                    break;
            }
        } while (choice >= 0 && choice < 4);
    }
}
