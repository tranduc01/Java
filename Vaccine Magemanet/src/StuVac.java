
import java.util.Calendar;
import java.sql.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class StuVac extends Student {

    String vId;
    String place1;
    String d1;
    String place2;
    String d2;
    String vName;

    public StuVac(Student st) {
        st.sID = this.sID;
        st.sName = this.sName;
    }

    public StuVac(String sID, String sName) {
        super(sID, sName);
    }

    public StuVac(String sID, String vId, String vName, String place1, String d1, String place2, String d2) {
        this.sID = sID;
        this.vId = vId;
        this.vName = vName;
        this.place1 = place1;
        this.d1 = d1;
        this.place2 = place2;
        this.d2 = d2;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
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

    public long toDate(String ymd) {
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

    public String first() {
        boolean go = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                sc = new Scanner(System.in);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("Input date1(yyyy-m-d): ");
                d1 = sc.nextLine().trim();
                long t = toDate(d1);
                Date d3 = new Date(t);
                System.out.println(d3);
                go = false;
                if (t < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Date is invalid.");
                go = true;
            }
        } while (go);
        return d1;
    }

    public String second() {
        boolean go = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                sc = new Scanner(System.in);
                long t1 = toDate(this.getD1());
                Date d4 = new Date(t1);
                System.out.println("Input date2(yyyy-m-d): ");
                d2 = sc.nextLine().trim();
                long t = toDate(d2);
                Date d3 = new Date(t);
                System.out.println(d3);
                go = false;
                if (d3.toLocalDate().minusDays(28).isBefore(d4.toLocalDate()) || t < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Date is invalid.");
                System.out.println("The first injection must be at least 28 days apart from the second injection");
                go = true;
            }
        } while (go);
        return d2;
    }

    public String place1() {
        boolean go = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input place: ");
                place1 = sc.nextLine();
                go = false;
                if (place1.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Place cannot empty. PLease enter again");
                go = true;
            }
        } while (go);
        return place1;
    }

    public String place2() {
        boolean go = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Input place: ");
                place2 = sc.nextLine();
                go = false;
                if (place2.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Place cannot empty. PLease enter again");
                go = true;
            }
        } while (go);
        return place2;
    }

    public void output() {
        System.out.println("sID:" + sID + " ," + "vId:" + vId + ", vName:" + vName + ", place1:" + place1 + ", d1:" + d1 + ", place2:" + place2 + ", d2:" + d2);
    }

    @Override
    public String toString() {
        return sID + "," + vId + "," + vName + "," + place1 + "," + d1 + "," + place2 + "," + d2;
    }

}
