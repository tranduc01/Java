/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class CodeWord implements Serializable {

    int symbol;
    String codeword;

    public CodeWord(int symbol) {
        this.symbol = symbol;
        this.codeword = "";
    }

    public CodeWord(int symbol, String codeword) {
        this.symbol = symbol;
        this.codeword = codeword;
    }

    @Override
    public String toString() {
        return "(" + symbol + ":" + codeword + ")";
    }

}
