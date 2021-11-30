
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class StuVacList extends ArrayList<StuVac> {

    Scanner sc = new Scanner(System.in);

    public StuVacList() {
        super();
    }
    public StuVacList(StudentList stList) {
        this.stList = stList;
    }
    StudentList stList;
    public void display() {
        for (StuVac stuvac : this) {
            stuvac.output();
        }
    }

    public void display3(StudentList stList) {
        System.out.println("---List of students who have not been vaccinated---");
        for (StuVac stuvac : this) {
            if (stuvac.getD2().equals(" ") && stuvac.getPlace2().equals(" ") && stuvac.getD1().equals(" ") && stuvac.getPlace1().equals(" ")) {
                Student st = stList.searchStu(stuvac.getsID());
                if (st != null) {
                    System.out.println("-----------------");
                    System.out.println("Name: " + st.getsName());
                    stuvac.output();
                }
            }
        }
    }

    public void display1(StudentList stList) {
        System.out.println("---List of students who received the first injection---");
        for (StuVac stuvac : this) {
            if (stuvac.getD2().equals(" ") && stuvac.getPlace2().equals(" ") && !(stuvac.getD1().equals(" "))) {
                Student st = stList.searchStu(stuvac.getsID());
                if (st != null) {
                    System.out.println("-----------------");
                    System.out.println("Name: " + st.getsName());
                    stuvac.output();
                }
            }
        }
    }

    public void display2(StudentList stList) {
        System.out.println("---List of students who have had 2 injections---");
        for (StuVac stuvac : this) {
            if (!stuvac.getD2().equals(" ") && !stuvac.getPlace2().equals(" ")) {
                Student st = stList.searchStu(stuvac.getsID());
                if (st != null) {
                    System.out.println("-----------------");
                    System.out.println("Name: " + st.getsName());
                    stuvac.output();
                }
            }
        }
    }

    public void addFromFile(String filename, StudentList stList) {
        try {
            FileReader f1 = new FileReader(filename);
            BufferedReader bf = new BufferedReader(f1);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String sId = stk.nextToken();
                String vId = stk.nextToken();
                String vName = stk.nextToken();
                String place1 = stk.nextToken();
                String date1 = stk.nextToken();
                String place2 = stk.nextToken();
                String date2 = stk.nextToken();
                StuVac stuvac = new StuVac(sId, vId, vName, place1, date1, place2, date2);
                this.add(stuvac);
            }
            f1.close();
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Student stu : stList) {
            StuVac stuvac = search(stu.getsID());
            if ((stuvac == null)) {
                StuVac stvac = new StuVac(stu.sID, " ", " ", " ", " ", " ", " ");
                this.add(stvac);
            }
        }
    }

    public void saveFile(String filename) {
        try {
            PrintWriter w = new PrintWriter(filename);
            for (int i = 0; i < this.size(); i++) {
                w.println(this.get(i).toString());
            }
            w.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Saved !!!");
    }

    public StuVac search(String id) {
        for (StuVac stuvac : this) {
            if (stuvac.getsID().equals(id)) {
                return stuvac;
            }
        }
        return null;
    }

    public StuVac search1(String id, StudentList list) {
        for (StuVac stuvac : this) {
            if ((stuvac.getsID().equals(id))) {
                Student st = list.searchStu(stuvac.getsID());
                System.out.println("Name: " + st.getsName());
                stuvac.output();
                return stuvac;
            }
        }
        return null;
    }

    public void updateVaccination() {
        System.out.println("Input student'ID");
        String id = sc.nextLine();
        StuVac stuvac = search(id);
        int choice, choice1 = 0;
        boolean go = true;
        if (stuvac != null) {
            if (stuvac.d1 != null && stuvac.place1 != null && stuvac.d2.equals(" ")) {
                System.out.println("-Got the first injection-");
                do {
                    System.out.println("Which part you want to update ??");
                    System.out.println("1. Add iformation for seccond injection");
                    System.out.println("2. Edit information for first injection");
                    System.out.println("3. Return");
                    System.out.println("Your choice: ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            sc = new Scanner(System.in);
                            System.out.println("---Second Injection---");
                            stuvac.setPlace1(stuvac.place2());
                            stuvac.setD2(stuvac.second());
                            break;
                        case 2:
                            sc = new Scanner(System.in);
                            System.out.println("---First Injection---");
                            stuvac.setPlace1(stuvac.place1());
                            stuvac.setD1(stuvac.first());
                            break;
                    }
                } while (choice >= 0 && choice < 3);
            } else {
                System.out.println("-Completed 2 doses of vaccine-");
                do {
                    System.out.println("Which part you want to update ??");
                    System.out.println("1. Edit iformation for first injection");
                    System.out.println("2. Edit information for second injection");
                    System.out.println("3. Return");
                    System.out.println("Your choice: ");
                    choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            sc = new Scanner(System.in);
                            System.out.println("---First Injection---");
                            stuvac.setPlace1(stuvac.place1());
                            stuvac.setD1(stuvac.first());
                            break;
                        case 2:
                            sc = new Scanner(System.in);
                            System.out.println("---Second Injection---");
                            stuvac.setPlace1(stuvac.place2());
                            stuvac.setD2(stuvac.second());
                            break;
                    }
                } while (choice1 >= 0 && choice1 < 3);
            }
        } else {
            System.out.println("Student Not Found !!!");
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean go = true;
        System.out.println("Input studen's ID:");
        String sID = sc.nextLine();
        StuVac stuvac = search(sID);
        if (stuvac != null) {
            if (stuvac.vId.equals(" ")) {
                System.out.println("Students have not been vaccinated");
                System.out.println("--Add injection information for this student--");
                System.out.println("Choose vaccine: ");
                System.out.println("1. Covid-V001,AstraZeneca");
                System.out.println("2. Covid-V002,Sputnik V");
                System.out.println("3. Covid-V003,Vero Cell");
                System.out.println("4. Covid-V004,Pfizer");
                System.out.println("5. Covid-V005,Moderna");
                System.out.println("You choose:");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        stuvac.setvId("Covid-V001");
                        stuvac.setvName("AstraZeneca");
                        break;
                    case 2:
                        stuvac.setvId("Covid-V002");
                        stuvac.setvName("Sputnik V");
                        break;
                    case 3:
                        stuvac.setvId("Covid-V003");
                        stuvac.setvName("Vero Cell");
                        break;
                    case 4:
                        stuvac.setvId("Covid-V004");
                        stuvac.setvName("Pfizer");
                        break;
                    case 5:
                        stuvac.setvId("Covid-V005");
                        stuvac.setvName("Moderna");
                        break;
                }
                stuvac.setPlace1(stuvac.place1());
                stuvac.setD1(stuvac.first());
                long t = stuvac.toDate(stuvac.getD1());
                Date d3 = new Date(t);
                Date d = new Date(System.currentTimeMillis());
                if (d3.toLocalDate().plusDays(28).isBefore(d.toLocalDate())) {
                    sc = new Scanner(System.in);
                    System.out.println("Do you want to add second injection???(Y/N)");
                    String input = sc.nextLine();
                    if (input.startsWith("Y") || input.startsWith("y")) {
                        sc = new Scanner(System.in);
                        System.out.println("---Second Injection---");
                        stuvac.setPlace1(stuvac.place2());
                        stuvac.setD2(stuvac.second());
                    } else if (input.startsWith("n") || input.startsWith("N")) {
                        System.out.println("Got the first injection");
                    }
                } else {
                    System.out.println("Got the first injection");
                }
            } else if (stuvac.d1 != null && stuvac.place1 != null && stuvac.d2.equals(" ")) {
                System.out.println("Got the first injection");
                String input;
                System.out.println("Do you want do add information for second injection????(Y/N)");
                input = sc.nextLine();
                while (input.startsWith("y") || input.startsWith("Y")) {
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("---Second Injection---");
                            System.out.println("Input place: ");
                            stuvac.setPlace2(sc.nextLine());
                            go = false;
                            if (stuvac.place2.isEmpty()) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Place cannot empty. PLease enter again");
                            go = true;
                        }
                    } while (go);
                    stuvac.setD2(stuvac.second());
                    break;
                }
            } else {
                System.out.println("Completed 2 doses of vaccine");
            }
        } else {
            System.out.println("Not Found !!!");
        }
    }

    public void removeInfor() {
        System.out.println("Input student'ID:");
        String id = sc.nextLine();
        StuVac st = this.search(id);
        if (st != null) {
            System.out.println("Are you sure??(Y/N)");
            String input = sc.nextLine();
            if (input.startsWith("y") || input.startsWith("Y")) {
                this.remove(st);
                System.out.println("Removed");
            } else {
                System.out.println("Remove Fail");
            }
        } else {
            System.out.println("Not Found !!!");
        }
    }
}
