/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author USER
 */
public class HuffmanEncoder {

    CodeWordTable codeTable;
    String endodedStr = "";
    InputStream source;
    boolean encoded = false;
    int srcByteNumber = 0;
    int zipByteNumber = 0;

    public HuffmanEncoder(InputStream source) {
        try {
            srcByteNumber = source.available();
            this.encode(source);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public HuffmanEncoder(String srcStr) {
        byte[] symbols = srcStr.getBytes();
        srcByteNumber = symbols.length;
        try {
            ByteArrayInputStream iStream = new ByteArrayInputStream(symbols);
            this.encode(iStream);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HuffmanEncoder(File srcFile) {
        if (!srcFile.exists()) {
            System.out.println("The file:" + srcFile.getName() + "doesn't exist");
            System.exit(0);
        }
        try {
            FileInputStream fi = new FileInputStream(srcFile);
            byte[] symbols = new byte[fi.available()];
            fi.read(symbols);
            fi.close();
            ByteArrayInputStream iStream = new ByteArrayInputStream(symbols);
            this.encode(iStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void encode(InputStream source) {
        encoded = false;
        this.source = source;
        FregCounter fregCounter = new FregCounter(source);
        HuffmanTree tree = new HuffmanTree(fregCounter);
        CodeWordGenerator codeGen = new CodeWordGenerator(tree);
        codeGen.generateCodewords();
        codeTable = codeGen.getCodeTable();
        createEncodedStr();
        encoded = true;
    }

    private boolean createEncodedStr() {
        endodedStr = "";
        try {
            if (source == null || source.available() == 0) {
                System.out.println("Source is empty!");
                return false;
            }
            int symbol;
            this.source.reset();
            while ((symbol = source.read()) != -1) {
                String code = codeTable.get(symbol).codeword;
                endodedStr += code;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public HuffmanZipResult createZipResult(String srcName) {
        if (!encoded) {
            return null;
        }
        HuffmanZipResult result = new HuffmanZipResult();
        result.srcName = srcName;
        result.minCodeTable = this.codeTable.reduce();
        int L = endodedStr.length();
        int remainder = L % 8;
        result.numberOfLastBit = remainder;
        int zipLen = L / 8;
        result.zippedData = new byte[zipLen + (remainder > 0 ? 1 : 0)];
        int pos = 0, nextPos;
        int zipData;
        for (int i = 0; i < zipLen; i++) {
            nextPos = pos + 8;
            String str8 = endodedStr.substring(pos, pos + 8);
            zipData = Integer.parseInt(str8, 2);
            result.zippedData[i] = (byte) zipData;
            pos = nextPos;
        }
        if (remainder > 0) {
            String str8 = endodedStr.substring(L - remainder, L);
            while (str8.length() < 8) {
                str8 += "0";
            }
            zipData = Integer.parseInt(str8, 2);
            int lastByteIndex = result.zippedData.length - 1;
            result.zippedData[lastByteIndex] = (byte) zipData;
        }
        this.zipByteNumber = result.zippedData.length;
        return result;
    }

    public boolean writeZipFile(String srcFilename, String zipFilename) {
        if (!this.encoded) {
            System.out.println("Encoding operation is not performed yet!");
            return false;
        }
        HuffmanZipResult zipResult = createZipResult(srcFilename);
        try {
            FileOutputStream fo = new FileOutputStream(zipFilename);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(zipResult);
            oo.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public double getCompressRate() {
        int d1 = this.srcByteNumber;
        int d2 = this.zipByteNumber;
        return 1.0 * (d1 - d2) / d1;
    }

    public CodeWordTable getCodeTable() {
        return codeTable;
    }

    public void setCodeTable(CodeWordTable codeTable) {
        this.codeTable = codeTable;
    }

    public String getEndodedStr() {
        return endodedStr;
    }

    public void setEndodedStr(String endodedStr) {
        this.endodedStr = endodedStr;
    }

    public InputStream getSource() {
        return source;
    }

    public void setSource(InputStream source) {
        this.source = source;
    }

}
