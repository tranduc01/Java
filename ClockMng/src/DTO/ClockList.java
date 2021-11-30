/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ClockList extends LinkedList<Clock> {

    Scanner sc = new Scanner(System.in);

    public void addClock() {
        Clock c = new Clock();
        c.input();
        if (this.add(c) == true) {
            System.out.println("Added Successfully");
        } else {
            System.out.println("Added Failed!");
        }
    }

    private int search(String id) {
        return this.indexOf(new Clock(id));
    }

    public void removeClock() {
        String id;
        System.out.println("Input clock's id you want do remove: ");
        id = sc.nextLine();
        int pos = search(id);
        if (pos < 0) {
            System.out.println("Not Found!");
        } else {
            this.remove(pos);
            System.out.println("Clock " + id + " was deleted");
        }
    }

    public void updateClock() {
        String id;
        System.out.println("Input clock's id you want to update: ");
        id = sc.nextLine();
        int pos = search(id);
        if (pos < 0) {
            System.out.println("Not Found");
        } else {
            this.get(pos).input();
            System.out.println("Clock" + id + "was upadated.");
        }
    }

    public void print() {
        for (Clock c : this) {
            System.out.println(c);
        }
    }

    public void printPrice() {
        int price1, price2;
        System.out.println("Input Price Range ");
        System.out.println("Price 1:");
        price1 = Integer.parseInt(sc.nextLine());
        System.out.println("Price 2:");
        price2 = Integer.parseInt(sc.nextLine());
        if (price1 > price2) {
            int tmp = price1;
            price1 = price2;
            price2 = tmp;
        }
        for (Clock c : this) {
            int price = c.getPrice();
            if (price >= price1 && price <= price2) {
                System.out.println(c);
            }
        }
    }
}
