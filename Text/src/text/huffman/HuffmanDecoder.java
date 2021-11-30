/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class HuffmanDecoder {

    HuffmanZipResult zipResult;
    byte[] zippedData;
    int numberOfLastBit;
    CodeWordTable codeTable;
    HuffmanTree tree;
    byte[] srcData;
    boolean decoded = false;
    String decodingBitString = "";

    public HuffmanDecoder(HuffmanZipResult zipResult) {
        this.zipResult = zipResult;
        zippedData = zipResult.zippedData;
        codeTable = zipResult.minCodeTable;
        numberOfLastBit = zipResult.numberOfLastBit;
    }

    public HuffmanDecoder(File decodedFile) {
        decoded = false;
        if (!decodedFile.exists()) {
            System.out.println("The file:" + decodedFile.getName() + "doesn't exist!");
            System.exit(0);
        } else {
            try {
                FileInputStream fi = new FileInputStream(decodedFile);
                ObjectInputStream oi = new ObjectInputStream(fi);
                zipResult = (HuffmanZipResult) (oi.readObject());
                zippedData = zipResult.zippedData;
                codeTable = zipResult.minCodeTable;
                numberOfLastBit = zipResult.numberOfLastBit;
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    private String convert8(int aByte) {
        String bitStr = Integer.toBinaryString(aByte);
        int L = bitStr.length();
        if (L > 8) {
            bitStr = bitStr.substring(L - 8, L);
        } else {
            while (bitStr.length() < 8) {
                bitStr = "0" + bitStr;
            }
        }
        return bitStr;
    }

    private byte decodeSymbol() {
        TreeNode t = tree.root;
        byte aSymbol;
        int i = 0;
        while (!t.isLeaf()) {
            char bit = decodingBitString.charAt(i++);
            if (bit == '0') {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        aSymbol = (byte) t.symbol;
        System.out.format("Decoding: BitStr:%15s => symbol:%3d, %c\n", decodingBitString, aSymbol, (char) aSymbol);
        decodingBitString = decodingBitString.substring(i);
        return aSymbol;
    }

    public void decode() {
        tree = new HuffmanTree();
        tree.reBuild(codeTable);
        int L = zippedData.length;
        ArrayList<Byte> temp = new ArrayList();
        String bitStr8 = "";
        decodingBitString = "";
        for (int i = 0; i < zippedData.length - 1; i++) {
            int data = zippedData[i];
            bitStr8 = convert8(data);
            decodingBitString += bitStr8;
            if (decodingBitString.length() > 15) {
                while (decodingBitString.length() > 15) {
                    temp.add((Byte) (decodeSymbol()));
                }
            }
        }
        String lastByte = convert8(zippedData[L - 1]);
        lastByte = lastByte.substring(0, numberOfLastBit);
        bitStr8 = lastByte;
        decodingBitString += bitStr8;
        while (decodingBitString.length() > 0) {
            temp.add(decodeSymbol());
        }
        int srcLen = temp.size();
        this.srcData = new byte[srcLen];
        for (int i = 0; i < srcLen; i++) {
            srcData[i] = temp.get(i).byteValue();
        }
        decoded = true;
    }

    public boolean writeDecodedResult(String filename) {
        if (!decoded) {
            this.decode();
        }
        File f = new File(filename);
        try {
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(srcData);
            fo.flush();
            fo.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    public String getSrcString() {
        if (!decoded) {
            return null;
        }
        return new String(srcData);
    }

    public CodeWordTable getCodeTable() {
        return codeTable;
    }

    public HuffmanTree getTree() {
        return tree;
    }

    public byte[] getSrcData() {
        return srcData;
    }

}
