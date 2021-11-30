
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public boolean addStu(Student s) {
        return this.add(s);
    }

    public void displayStu() {
        for (Student s : this) {
            s.outputStu();
        }
    }

    public Student searchStu(String sID) {
        for (Student s : this) {
            if (s.getsID().equals(sID)) {
                return s;
            }
        }
        return null;
    }

    public Student findStu(String sID) {
        for (Student s : this) {
            if (!(s.getsID().equals(sID))) {
                return s;
            }
        }
        return null;
    }

    public void addFromFile(String filename) {
        try {
            FileReader f1 = new FileReader(filename);
            BufferedReader bf = new BufferedReader(f1);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] tmp = s.split(",");
                if (tmp.length == 2) {
                    Student stu = new Student(tmp[0], tmp[1]);
                    this.add(stu);
                }
            }
            f1.close();
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
