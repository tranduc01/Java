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
public class TreeNode implements Comparable<TreeNode> {

    int symbol;
    int freg;
    TreeNode left, right;

    public TreeNode(int symbol, int freg) {
        this.symbol = symbol;
        this.freg = freg;
        left = right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(TreeNode o) {
        int d = freg - o.freg;
        return d > 0 ? -1 : d < 0 ? 1 : 0;
    }

}
