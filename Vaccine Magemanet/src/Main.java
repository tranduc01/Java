
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VaccineList vlist = new VaccineList();
        StudentList slist = new StudentList();
        StuVacList stvclist = new StuVacList();
        vlist.addFromFile("Vaccines.txt");
        slist.addFromFile("Student.txt");
        stvclist.addFromFile("Vaccinations.txt", slist);
        Menu menu = new Menu();
        menu.add("List of all students have been injected");
        menu.add("List of all students have not been injected");
        menu.add("Add student's vaccine injection information");
        menu.add("Updating information of students' vaccine injection");
        menu.add("Delete student vaccine injection information");
        menu.add("Search for injection information by studentID");
        menu.add("Save to File");
        menu.add("Quit");
        int choice = 0;
        boolean go = true;
        do {
            try {
                do {
                    choice = menu.getUserChoice();
                    switch (choice) {
                        case 1:
                            stvclist.display1(slist);
                            stvclist.display2(slist);
                            break;
                        case 2:
                            stvclist.display3(slist);
                            break;
                        case 3:
                            stvclist.input();
                            break;
                        case 4:
                            stvclist.updateVaccination();
                            break;
                        case 5:
                            stvclist.removeInfor();
                            break;
                        case 6:
                            System.out.println("Input student'ID:");
                            String id = sc.nextLine();
                            if (stvclist.search1(id, slist) != null) {
                                System.out.println("Founded !!!");
                            } else {
                                System.out.println("Not Found !!!");
                            }
                            break;
                        case 7:
                            stvclist.saveFile("Vaccinations.txt");
                            break;
                    }
                } while (choice >= 0 && choice < 8);
                go = false;
                if (choice < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input number 1-8.");
                go = true;
            }
        } while (go);
    }
}
