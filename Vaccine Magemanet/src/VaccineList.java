
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
public class VaccineList extends ArrayList<Vaccine> {

    Scanner sc = new Scanner(System.in);
    ArrayList<Vaccine> list;

    public VaccineList() {
        list = new ArrayList<>();
    }

    public boolean addVaccine(Vaccine v) {
        return list.add(v);
    }

    public void displayVaccine() {
        for (Vaccine v : list) {
            v.outputVaccine();
        }
    }

    public void addFromFile(String filename) {
        try {
            FileReader f1 = new FileReader(filename);
            BufferedReader bf = new BufferedReader(f1);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] tmp = s.split(",");
                if (tmp.length == 2) {
                    Vaccine v = new Vaccine(tmp[0], tmp[1]);
                    list.add(v);
                }
            }
            f1.close();
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
