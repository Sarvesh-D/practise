
package com.ds.datastructures;

import java.util.Objects;
import java.util.Optional;

import lombok.Getter;
import lombok.ToString;

import javax.swing.text.html.Option;

/**
 * A Binary Tree
 * 
 * @author Sarvesh Dubey
 *
 */
@Getter
@ToString(of = "data")
public class BinaryTree<T extends Comparable<T>> {

    private final T data;

    private BinaryTree<T> left;

    private BinaryTree<T> right;

    int lDepth = 0;

    int rDepth = 0;

    private BinaryTree<T> rootNode;

    public BinaryTree(T i) {
        this.data = i;
        rootNode = this;
    }

    public BinaryTree<T> insert(T item) {
        return insert(item, rootNode);
    }

    private BinaryTree<T> insert(T item, BinaryTree<T> node) {
        if (Objects.isNull(node))
            return new BinaryTree<>(item);
        else if (item.compareTo(node.data) <= 0)
            node.left = insert(item, node.left);
        else
            node.right = insert(item, node.right);
        return node;
    }

    public Optional<BinaryTree<T>> search(T item) {
        return search(item, rootNode);
    }

    private Optional<BinaryTree<T>> search(T item, BinaryTree<T> rootNode) {
        if (Objects.isNull(rootNode))
            return Optional.empty();
        else if (item.equals(rootNode.data))
            return Optional.of(rootNode);
        else if (item.compareTo(rootNode.data) <= 0)
            return search(item, rootNode.left);
        else
            return search(item, rootNode.right);
    }

    /**
     * Removes the given item and all it's child (if any) from this {@link BinaryTree}.
     * @param item to be removed.
     * @return BinaryTree for chaining
     */
    public BinaryTree<T> remove(T item) {
        return remove(item, rootNode);
    }

    private BinaryTree<T> remove(T item, BinaryTree<T> rootNode) {
        if (item.equals(rootNode.data)) {
            rootNode.left = null;
            rootNode.right = null;
            this.rootNode = null;
        } else if (item.compareTo(rootNode.data) <= 0) {
            remove(item, rootNode.left);
            rootNode.left = null;
        }
        else {
            remove(item, rootNode.right);
            rootNode.right = null;
        }
        return this.rootNode;
    }

    public Optional<T> max() {
        return max(rootNode);
    }

    private Optional<T> max(BinaryTree<T> rootNode) {
        if(null == rootNode)
            return Optional.empty();
        else if(null == rootNode.right)
            return Optional.of(rootNode.data);
        else
            return max(rootNode.right);
    }

    public Optional<T> min() {
        return min(rootNode);
    }

    private Optional<T> min(BinaryTree<T> rootNode) {
        if(null == rootNode)
            return Optional.empty();
        else if(null == rootNode.left)
            return Optional.of(rootNode.data);
        else
            return min(rootNode.left);
    }

    public int height() {
        return height(rootNode);
    }

    private int height(BinaryTree<T> rootNode) {
        if(null == rootNode)
            return -1;
        return Math.max(height(rootNode.left), height(rootNode.right)) + 1;
    }

    public void print() {
        BTreePrinter.printNode(this);
    }

}
