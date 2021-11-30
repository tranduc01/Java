/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Clock {

    String id = "", manufact = "";
    int price = 0, guarantee = 0;
    Scanner sc = new Scanner(System.in);

    public Clock() {
    }

    public Clock(String id) {
        this.id = id;
    }

    public Clock(String id, String manufact, int price, int guarantee) {
        this.id = id;
        this.manufact = manufact;
        this.price = price;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public String toString() {
        return id + " , " + manufact + ", " + price + ", " + guarantee;
    }

    public void input() {
        System.out.println("Input ID: ");
        id = sc.nextLine();
        System.out.println("Input Manufact: ");
        manufact = sc.nextLine();
        System.out.println("Input price: ");
        price = sc.nextInt();
        System.out.println("Input Guarantee: ");
        guarantee = sc.nextInt();
    }


    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Clock) obj).id);
    }

}
