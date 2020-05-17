
package com.ds.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Custom implementation of {@link java.util.LinkedList}.
 * This is a basic implementation for learning purpose and not an industry standard version of {@link java.util.LinkedList}.
 * @param <T> Type of items the List can store
 * @author Sarvesh-D
 */
public class MyLinkedList<T> {

    @Getter
    private Node<T> head;

    @RequiredArgsConstructor
    @EqualsAndHashCode(of = "item")
    @Getter
    public static class Node<T> {

        private final T item;

        private Node<T> prev;

        private Node<T> next;

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    public MyLinkedList(T item) {
        this.head = new Node<T>(item);
    }

    public MyLinkedList(List<T> items) {
        this(items.get(0));
        items.subList(1, items.size())
             .forEach(this::append);
    }

    /**
     * Adds item to end of {@link MyLinkedList}
     * @param item to add
     * @return {@link MyLinkedList} for chaining
     */
    public MyLinkedList<T> append(T item) {
        Node<T> end = head;
        while (null != end.next)
            end = end.next;

        Node<T> newEnd = new Node<>(item);
        end.next = newEnd;
        newEnd.prev = end;
        return this;
    }

    /**
     * Adds item at beginning of {@link MyLinkedList}
     * @param item to add
     * @return {@link MyLinkedList} for chaining
     */
    public MyLinkedList<T> prepend(T item) {
        Node<T> first = new Node<>(item);
        first.next = head;
        head.prev = first;
        head = first;
        return this;
    }

    /**
     * Adds item at specified index of {@link MyLinkedList}
     * @param item to add
     * @param index at which item should be added
    *  @return {@link MyLinkedList} for chaining
     * @throws IllegalArgumentException if the index does not exists in the {@link MyLinkedList}
     */
    public MyLinkedList<T> insert(T item, int index) throws IllegalArgumentException {
        if (index == 0)
            prepend(item);
        else {
            Node<T> newNode = new Node<>(item);
            Node<T> currNode = getNode(index);
            newNode.next = currNode;
            newNode.prev = currNode.prev;
            currNode.prev = newNode;
            getNode(index - 1).next = newNode;
        }
        return this;
    }

    /**
     * Removes item at specified index of {@link MyLinkedList}
     * @param index of item to remove
     * @return {@link MyLinkedList} for chaining
     * @throws IllegalArgumentException if the index does not exists in the {@link MyLinkedList}
     */
    public MyLinkedList<T> remove(int index) throws IllegalArgumentException {
        Node<T> nodeToRemove = getNode(index);
        nodeToRemove.prev = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        return this;
    }

    /**
     * Removes item from the end of {@link MyLinkedList}
     * @return {@link MyLinkedList} for chaining
     */
    public MyLinkedList<T> remove() {
        Node<T> tail = head;
        while (null != tail.next)
            tail = tail.next;
        Node<T> newTail = tail.prev;
        newTail.next = null;
        return this;
    }

    /**
     * Removes the head of {@link MyLinkedList}
     * @return {@link MyLinkedList} for chaining
     */
    public MyLinkedList<T> removeHead() {
        head = head.next;
        head.prev = null;
        return this;
    }

    /**
     * Finds the mid element of the {@link MyLinkedList}
     * @return the mid element
     * @implNote The mid is calculated by dividing the {@link MyLinkedList#asList()} by 2.
     */
    public T mid() {
        throw new NotImplementedException();
    }

    /**
     * Finds the {@link Node} at the specified index from {@link MyLinkedList}
     * @param index of {@link Node} to be fetched
     * @return {@link Node} at the specified index or tail if the index is -ve
     * @throws IllegalArgumentException if the index does not exists in the {@link MyLinkedList}
     */
    public Node<T> getNode(int index) {
        int i = 0;
        Node<T> targetNode = head;
        while (i != index && null != targetNode.next) {
            targetNode = targetNode.next;
            i++;
        }
        return targetNode;
    }

    /**
     * Finds the item at the specified index from {@link MyLinkedList}
      * @param index of item to be fetched
     * @return element at the specified index
     * @throws IllegalArgumentException if the index does not exists in the {@link MyLinkedList}
     */
    public T get(int index) throws IllegalArgumentException {
        return getNode(index).item;
    }

    /**
     * Gets the item at head of the {@link MyLinkedList}
     * @return head of the {@link MyLinkedList}
     */
    public T head() {
        return get(0);
    }

    /**
     * Gets the item at tail of the {@link MyLinkedList}
     * @return tail of the {@link MyLinkedList}
     */
    public T tail() {
        return get(-1);
    }

    public List<T> asList() {
        List<T> items = new ArrayList<>();
        Node<T> node = head;
        items.add(node.item);
        while (null != node.next) {
            node = node.next;
            items.add(node.item);
        }
        return items;
    }

    private final StringJoiner pretty = new StringJoiner(" --> ", " --> ", " --> ");

    @Override
    public String toString() {
        return pretty(this.head);
    }

    public String pretty(Node<T> head) {
        if (Objects.nonNull(head)) {
            pretty.add(head.toString());
            pretty(head.next);
        }
        return pretty.toString();
    }
}
