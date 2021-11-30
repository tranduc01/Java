/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author USER
 */
public class FregCounter {

    int numberOfSymbol = 0;
    Sym_Freg fregObjs[];

    public FregCounter() {
        fregObjs = new Sym_Freg[256];
    }

    public FregCounter(InputStream source) {
        fregObjs = new Sym_Freg[256];
        if (buildFromSource(source) == false) {
            throw new RuntimeException("Counting frequencies failed!");
        }
    }

    private void reset() {
        numberOfSymbol = 0;
        for (int i = 0; i < 256; i++) {
            fregObjs[i] = new Sym_Freg(i, 0);
        }
    }

    public boolean buildFromSource(InputStream source) {
        this.reset();
        source.mark(0);
        try {
            if (source == null || source.available() == 0) {
                System.out.println("Source is empty!");
                return false;
            }
            int symbol;
            while ((symbol = source.read()) != -1) {
                fregObjs[symbol].freg++;
                numberOfSymbol++;
            }
            source.reset();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public int getNumberOfSymbol() {
        return numberOfSymbol;
    }

    public void setNumberOfSymbol(int numberOfSymbol) {
        this.numberOfSymbol = numberOfSymbol;
    }

    public Sym_Freg[] getFregObjs() {
        return fregObjs;
    }

    public void setFregObjs(Sym_Freg[] fregObjs) {
        this.fregObjs = fregObjs;
    }

    public void decreaseSort() {
        Arrays.sort(fregObjs);
    }

    @Override
    public String toString() {
        String result = "" + this.numberOfSymbol + "[";
        for (Sym_Freg x : this.fregObjs) {
            if (x.freg > 0) {
                result += x + ",";
            }
        }
        return result + "]";
    }

}
