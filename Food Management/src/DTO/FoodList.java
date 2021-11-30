/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author USER
 */
public class FoodList implements Serializable{

    ArrayList<Food> list;

    public FoodList() {
        list = new ArrayList<>();
    }

    public void displayFood() {
        for (Food f : list) {
            f.outputFood();
        }
    }

    public boolean addFood(Food f) {
        return list.add(f);
    }

    public Food searchFood(String name) {
        for (Food f : list) {
            if (f.getName().equals(name)) {
                f.outputFood();
                return f;
            }
        }
        return null;
    }

    public Food findFood(int id) {
        for (Food f : list) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public boolean removeFood(int id) {
        Food f = findFood(id);
        return list.remove(f);
    }

    public void sortDate() {
        Collections.sort(list);
    }

    public void saveFile(String filename) {
        try {
            PrintWriter w= new PrintWriter(filename);
            for (int i=0;i<list.size();i++) {
            w.println(list.get(i).toString());
        }
        w.close();
        } catch (Exception e) {
            System.out.println(e);
        
    }
}
    public void readText(String filename){
        try {
            FileReader f2 = new FileReader("food.txt");
            BufferedReader bf = new BufferedReader(f2);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] tmp = s.split(",");
                if (tmp.length == 6) {
                    Food f = new Food(Integer.parseInt(tmp[0]), tmp[1], Integer.parseInt(tmp[2]), tmp[3], Integer.parseInt(tmp[4]), tmp[5]);
                    list.add(f);
                }
            }
            f2.close();
            bf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
