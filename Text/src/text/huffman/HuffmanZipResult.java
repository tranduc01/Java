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
public class HuffmanZipResult implements java.io.Serializable {

    String srcName = null;
    int numberOfLastBit = 0;
    CodeWordTable minCodeTable = null;
    byte[] zippedData;

    @Override
    public String toString() {
        String S = "";
        S += "Source name:" + srcName + "\n";
        S += "Number of last bit:" + numberOfLastBit + "\n";
        S += "Code table:" + minCodeTable + "\n";
        S += "Data:" + new String(zippedData);
        return S;
    }

}
