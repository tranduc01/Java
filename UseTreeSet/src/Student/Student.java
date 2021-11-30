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
public class Student implements Comparable {

    String id;
    String name;
    int mark;

    public Student() {
        id = "";
        name = "";
        mark = 0;
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input id: ");
                id = sc.nextLine();
                go = false;
                if (id.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ID cannot be empty.");
                go = true;
            }
        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input name: ");
                name = sc.nextLine();
                go = false;
                if (name.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Name cannot be empty.");
                go = true;
            }
        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input mark: ");
                mark = sc.nextInt();
                go = false;
                if (mark < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mark must be a number.");
                go = true;
            }
        } while (go);
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + mark;
    }

    @Override
    public int compareTo(Object t) {
        return id.compareTo(((Student) t).id);

    }

}
