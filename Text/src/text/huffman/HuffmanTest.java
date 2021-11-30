/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.io.File;

/**
 *
 * @author USER
 */
public class HuffmanTest {

    public static void main(String[] args) {
        String src = "Don't le me alone to ngight";
        System.out.println("Test encoder on String:");
        System.out.println("_______________________");
        HuffmanEncoder encoder = new HuffmanEncoder(src);
        System.out.println("Source str.:" + src);
        System.out.println("Codeword table:" + encoder.getCodeTable());
        System.out.println("Encoded str.:" + encoder.getEndodedStr());
        HuffmanZipResult zResult = encoder.createZipResult("No name");
        System.out.println("\nInformation about zipped result:\n" + zResult);
        System.out.println("Zipping rate:" + encoder.getCompressRate() * 100 + "%");
        System.out.println("\nTest Decoder on String:");
        System.out.println("_______________________");
        HuffmanDecoder decoder = new HuffmanDecoder(zResult);
        decoder.decode();
        String decodedStr = decoder.getSrcString();
        System.out.println("Decoded string:" + decodedStr);
        String srcFilename = "test1.doc";
        String zipFilename = "test1_ZIPPED.huff";
        String decodedFilename = "test1_HUF_unzip.doc";

        File f = new File(srcFilename);
        System.out.println("Test encoder on File:");
        System.out.println("_______________________");
        System.out.println("Please wait to compress file.");
        encoder = new HuffmanEncoder(f);
        encoder.writeZipFile(srcFilename, zipFilename);
        System.out.println("Write zip file:done.\n");
        System.out.println("Zipping rate:" + encoder.getCompressRate() * 100 + "%");
        System.out.println("\nTest Decoder on File:");
        System.out.println("_______________________");
        f = new File(zipFilename);
        decoder = new HuffmanDecoder(f);
        System.out.println("Please wait to compress file.");
        decoder.decode();
        decoder.writeDecodedResult(decodedFilename);
        System.out.println("Decode: done.\n");
    }
}
