/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author USER
 */
public class StudentList extends TreeSet<Student> {

    public StudentList() {
        super();
    }

    public Student search(String id) {
        return this.ceiling(new Student(id));
    }

    public void add() {
        Student st = new Student();
        boolean go = true;
        do {
            st.input();
            go = false;
            if (this.search(st.getId()) != null) {
                System.out.println("Student'Id is already exist!");
                go = true;
            }
        } while (go);
        this.add(st);
    }

    public void output() {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
