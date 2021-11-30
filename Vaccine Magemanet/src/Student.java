/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Student {

    String sID;
    String sName;

    public Student() {
        sID = "";
        sName = "";
    }

    public Student(String sID, String sName) {
        this.sID = sID;
        this.sName = sName;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void outputStu() {
        System.out.println("Student's ID: " + sID + ", Student's name: " + sName);
    }

    @Override
    public String toString() {
        return "Student{" + "sID=" + sID + ", sName=" + sName + '}';
    }

}
