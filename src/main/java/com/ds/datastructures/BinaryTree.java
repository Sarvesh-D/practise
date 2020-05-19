
package com.ds.datastructures;

import java.util.*;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.ToString;

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
        } else {
            remove(item, rootNode.right);
            rootNode.right = null;
        }
        return this.rootNode;
    }

    /**
     * Deletes single node in the tree with given value and adjusts the children of this deleted node to maintain
     * the BST variant.
     * @param item to delete
     * @return the updated {@link BinaryTree}
     */
    public BinaryTree<T> delete(T item) {
        return delete(item, this.rootNode);
    }

    private BinaryTree<T> delete(T item, BinaryTree<T> rootNode) {
        if(null == rootNode)
            return rootNode;
        else if(item.compareTo(rootNode.data) < 0)
            rootNode.left = delete(item, rootNode.left);
        else if(item.compareTo(rootNode.data) > 0)
            rootNode.right = delete(item, rootNode.right);
        else {
            if(isLeafNode(rootNode)) {
                rootNode = null;
            } else if(null == rootNode.left) {
                BinaryTree<T> temp = rootNode;
                rootNode = rootNode.right;
                temp = null;
            } else if(null == rootNode.right) {
                BinaryTree<T> temp = rootNode;
                rootNode = rootNode.left;
                temp = null;
            }
        }
        return rootNode;
    }

    private boolean isLeafNode(BinaryTree<T> rootNode) {
        return children(rootNode) == 0;
    }

    private int children(BinaryTree<T> rootNode) {
        int childCount = 0;
        if(null != rootNode.left)
            childCount++;
        if(null != rootNode.right)
            childCount++;
        return childCount;
    }

    public Optional<T> max() {
        return max(rootNode);
    }

    private Optional<T> max(BinaryTree<T> rootNode) {
        if (null == rootNode)
            return Optional.empty();
        else if (null == rootNode.right)
            return Optional.of(rootNode.data);
        else
            return max(rootNode.right);
    }

    public Optional<T> min() {
        return min(rootNode);
    }

    private Optional<T> min(BinaryTree<T> rootNode) {
        if (null == rootNode)
            return Optional.empty();
        else if (null == rootNode.left)
            return Optional.of(rootNode.data);
        else
            return min(rootNode.left);
    }

    public int height() {
        return height(rootNode);
    }

    private int height(BinaryTree<T> rootNode) {
        if (null == rootNode)
            return -1;
        return Math.max(height(rootNode.left), height(rootNode.right)) + 1;
    }

    public Collection<T> traverse(TraverseMode mode) {
        switch (mode) {
            case PRE_ORDER:
                return preOrder(rootNode, Lists.newArrayList());
            case IN_ORDER:
                return inOrder(rootNode, Lists.newArrayList());
            case POST_ORDER:
                return postOrder(rootNode, Lists.newArrayList());
            case LEVEL_ORDER:
                return levelOrder(rootNode);
        }
        throw new IllegalArgumentException("Invalid traversal mode");
    }

    private Collection<T> inOrder(BinaryTree<T> rootNode, Collection<T> accumulator) {
        if (null == rootNode)
            return accumulator;
        inOrder(rootNode.left, accumulator);
        accumulator.add(rootNode.data);
        inOrder(rootNode.right, accumulator);
        return accumulator;
    }

    private Collection<T> preOrder(BinaryTree<T> rootNode, Collection<T> accumulator) {
        if (null == rootNode)
            return accumulator;
        accumulator.add(rootNode.data);
        preOrder(rootNode.left, accumulator);
        preOrder(rootNode.right, accumulator);
        return accumulator;
    }

    private Collection<T> postOrder(BinaryTree<T> rootNode, Collection<T> accumulator) {
        if (null == rootNode)
            return accumulator;
        postOrder(rootNode.left, accumulator);
        postOrder(rootNode.right, accumulator);
        accumulator.add(rootNode.data);
        return accumulator;
    }

    private Collection<T> levelOrder(BinaryTree<T> rootNode) {
        Collection<T> levelOrder = Lists.newArrayList();
        Queue<BinaryTree<T>> children = new LinkedList<>();
        if (Objects.isNull(rootNode))
            return levelOrder;
        children.add(rootNode);
        while (!children.isEmpty()) {
            BinaryTree<T> currentNode = children.poll();
            if (Objects.nonNull(currentNode.left))
                children.add(currentNode.left);
            if (Objects.nonNull(currentNode.right))
                children.add(currentNode.right);
            levelOrder.add(currentNode.data);
        }
        return levelOrder;
    }

    public void print() {
        BTreePrinter.printNode(this);
    }

    static enum TraverseMode {

        LEVEL_ORDER,
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER;

    }

}
