/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_Product;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Suggestion extends ArrayList<Product> implements Comparable<Suggestion> {

    double cost;

    public Suggestion() {
        super();
        cost = 0;
    }

    @Override
    public int compareTo(Suggestion o) {
        double d = this.cost - o.cost;
        if (d < 0) {
            return -1;
        }
        if (d > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String result = "";
        for (Product p : this) {
            result += p + " ,";
        }
        return result;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
