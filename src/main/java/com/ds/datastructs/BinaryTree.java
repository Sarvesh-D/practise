package com.ds.datastructs;

import java.util.Objects;

/**
 * A Binary Tree
 * 
 * @author Sarvesh Dubey
 *
 */
public class BinaryTree {

    final int data;

    BinaryTree left;

    BinaryTree right;

    int lDepth = 0;

    int rDepth = 0;

    private BinaryTree rootNode;

    public BinaryTree(int i) {
        this.data = i;
        rootNode = this;
    }

    public BinaryTree insert(int i) {
        return insert(i, rootNode);
    }

    private BinaryTree insert(int i, BinaryTree node) {
        if (i <= node.data) {
            if (Objects.nonNull(node.left))
                insert(i, node.left);
            else {
                node.left = new BinaryTree(i);
                lDepth++;
            }
        } else {
            if (Objects.nonNull(node.right))
                insert(i, node.right);
            else {
                node.right = new BinaryTree(i);
                rDepth++;
            }
        }
        return node;
    }

    public void print() {
        BTreePrinter.printNode(this);
    }

}
