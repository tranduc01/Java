/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

/**
 *
 * @author USER
 */
public class Sym_Freg implements Comparable<Sym_Freg> {

    int symbol;
    int freg;

    public Sym_Freg(int symbol, int freg) {
        this.symbol = symbol;
        this.freg = freg;
    }

    @Override
    public int compareTo(Sym_Freg t) {
        int d = this.freg - t.freg;
        return d > 0 ? -1 : d < 0 ? 1 : 0;
    }

    @Override
    public String toString() {
        return "(" + symbol + "," + freg + ')';
    }

}
