/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author USER
 */
public class Food implements Comparable<Food>, Serializable {

    int id;
    String name;
    int weight;
    String type;
    int place;
    String expireDate;

    public Food() {
        id = 0;
        name = "";
        weight = 0;
        type = "";
        place = 0;
        expireDate = "";
    }

    public Food(int id, String name, int weight, String type, int place, String expireDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }


    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || (y % 4 == 0) && (y % 100 != 0)) {
            result = true;
        }
        return result;
    }

    public static boolean valid(int y, int m, int d) {
        if (y < 0 || m < 0 || m > 12 || d < 0 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
    }

    public static long toDate(String ymd) {
        StringTokenizer stk = new StringTokenizer(ymd, "/-");
        int y = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        if (!valid(y, m, d)) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d);
        long t = cal.getTime().getTime();
        return t;
    }

    public void inputFood() {
        boolean go = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input food's information");
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input  food's ID: ");
                id = sc.nextInt();
                go = false;
                if (id < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ID must be a number. Please enter again");
                go = true;
            }
        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input food's name: ");
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
                System.out.println("Input  food's weight: ");
                weight = sc.nextInt();
                go = false;
                if (weight < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Weight must be a number. PLease enter again");
                go = true;
            }
        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input food's type: ");
                type = sc.nextLine();
                go = false;
                if (type.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Type cannot be empty.");
                go = true;
            }
        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input  food's place: ");
                place = sc.nextInt();
                go = false;
                if (place < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Place must be a number. PLease enter again");
                go = true;
            }
        } while (go);
//        do {
//            sc = new Scanner(System.in);
//            System.out.println("Input expired date:");
//            date = sc.nextLine();
//            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            df.setLenient(false);
//            try {
//                df.parse(date);
//                go = false;
//            } catch (Exception e) {
//                System.out.println("Invalid date. Please enter again (dd/mm/yyyy)");
//                go = true;
//            }
//        } while (go);
        do {
            try {
                sc = new Scanner(System.in);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("Input expired date(yyyy-m-d): ");
                System.out.println("Curent day: "+d);
                expireDate = sc.nextLine().trim();
                long t = toDate(expireDate);
                Date d1=new Date(t);
                System.out.println(d1);
                go = false;
                if ( t < 0 || d1.before(d) || d1.compareTo(d)==0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ExprireDate is invalid.");
                go = true;
            }
        } while (go);
    }

    public void outputFood() {
        System.out.println("id:" + id + ", " + "name:" + name + ", " + "weight(g):" + weight + ", " + "type:" + type + ", " + "place:" +place+ ", " + "date:" + expireDate);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + weight + "," + type + "," +place+ "," + expireDate;
    }

    

    @Override
    public int compareTo(Food f) {
        long t=toDate(f.getExpireDate());
        Date d=new Date(t);
        long t1=toDate(this.getExpireDate());
        Date d1=new Date(t1);
         if (d.compareTo(d1) > 0) {
            return 1;
        } else if (d.compareTo(d1) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
