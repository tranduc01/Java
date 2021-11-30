/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class StudentManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        Menu menu = new Menu();
        menu.add("Add Student");
        menu.add("Display All Student");
        menu.add("Search student");
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
                    Student st = list.search(id);
                    if (st == null) {
                        System.out.println("Student " + id + " does not exist");
                    } else {
                        System.out.println("Found: " + st);
                    }
                    break;
            }
        } while (choice >= 0 && choice < 4);
    }
}
