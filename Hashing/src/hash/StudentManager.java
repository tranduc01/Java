/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author USER
 */
public class StudentManager {

    public static void main(String[] args) {
        final String filename = "students.txt";
        Menu menu = new Menu();
        menu.add("Add new student");
        menu.add("Search student");
        menu.add("Remove a student");
        menu.add("Update a student");
        menu.add("Print the list");
        menu.add("Save the list to file");
        menu.add("Quit");
        int choice;
        StudentList list = new StudentList();
        list.loadFromFile(filename);
        do {
            System.out.println("/n---Student Manager---");
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    list.addStudent();
                    break;
                case 2:
                    list.searchStudent();
                    break;
                case 3:
                    list.removeStudent();
                    break;
                case 4:
                    list.upadateStudent();
                    break;
                case 5:
                    list.print();
                    break;
                case 6:
                    list.saveToFile(filename);
                    break;
            }
        } while (choice >= 0 && choice < 7);
    }
}
