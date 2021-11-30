/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.huffman;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class HuffmanTree {

    TreeNode root;
    FregCounter fregTable;

    public HuffmanTree() {
        root = null;
        fregTable = null;
    }

    public HuffmanTree(FregCounter fTable) {
        this.fregTable = fTable;
        createTree();
    }

    private TreeNode createIntermediate(int freg) {
        TreeNode newNode = new TreeNode(-1, freg);
        return newNode;
    }

    private void createTree() {
        fregTable.decreaseSort();
        ArrayList<TreeNode> treeList = new ArrayList<>();
        int i = 0;
        while (i < 256) {
            int symbol = fregTable.fregObjs[i].symbol;
            int freg = fregTable.fregObjs[i].freg;
            if (freg > 0) {
                treeList.add(new TreeNode(symbol, freg));
            } else {
                break;
            }
            i++;
        }
        int n = treeList.size();
        while (n > 1) {
            TreeNode node1 = treeList.get(n - 2);
            TreeNode node2 = treeList.get(n - 1);
            int sumFreg = node1.freg + node2.freg;
            TreeNode newNode = createIntermediate(sumFreg);
            newNode.left = node1;
            newNode.right = node2;
            treeList.remove(n - 1);
            treeList.remove(n - 2);
            i = n - 3;
            while (i >= 0 && treeList.get(i).freg <= newNode.freg) {
                i--;
            }
            treeList.add(i + 1, newNode);
            n = treeList.size();
        }
        root = treeList.get(0);
    }

    public void reBuild(int symbol, String codeword) {
        int n = codeword.length();
        char lastBit = codeword.charAt(n - 1);
        TreeNode t = root;
        for (int i = 0; i < codeword.length() - 1; i++) {
            char digit = codeword.charAt(i);
            if (digit == '0') {
                if (t.left == null) {
                    t.left = createIntermediate(0);
                }
                t = t.left;
            } else {
                if (t.right == null) {
                    t.right = createIntermediate(0);
                }
                t = t.right;
            }
        }
        TreeNode newNode = new TreeNode(symbol, 0);
        if (lastBit == '0') {
            t.left = newNode;
        } else {
            t.right = newNode;
        }
    }

    public boolean reBuild(CodeWordTable codeTable) {
        root = createIntermediate(0);
        for (int i = 0; i < codeTable.size(); i++) {
            int symbol = codeTable.get(i).symbol;
            String codeword = codeTable.get(i).codeword;
            reBuild(symbol, codeword);
        }
        return true;
    }
}
