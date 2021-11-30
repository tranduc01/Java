/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Clock {

    String id;
    String manufacturer;
    int price;
    public static Comparator comparator = new Comparator() {
        @Override
        public int compare(Object t, Object t1) {
            return ((Clock) t).id.compareTo(((Clock) t1).id);
        }
    };

    public Clock(String id) {
        this.id = id;
    }

    public Clock() {
        id = "";
        manufacturer = "";
        price = 0;
    }

    public Clock(String id, String manufacturer, int price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
                System.out.println("Input manufacturer: ");
                manufacturer = sc.nextLine();
                go = false;
                if (manufacturer.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Manufacturer cannot be empty.");
                go = true;
            }
        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input price: ");
                price = sc.nextInt();
                go = false;
                if (price < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Price must be a number.");
                go = true;
            }
        } while (go);
    }

    @Override
    public String toString() {
        return id + ", " + manufacturer + ", " + price;
    }

}
