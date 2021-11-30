/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author USER
 */
public class ClockList extends TreeSet<Clock> {

    public ClockList() {
        super(Clock.comparator);
    }

    public void add() {
        Clock c = new Clock();
        boolean go = true;
        do {
            c.input();
            go = false;
            if (this.search(c.getId()) != null) {
                System.out.println("Clock'Id is already exist!");
                go = true;
            }
        } while (go);
        this.add(c);
    }

    public Clock search(String id) {
        return this.ceiling(new Clock(id));
    }

    public void output() {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
