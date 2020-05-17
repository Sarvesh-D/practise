
package com.ds.datastructures;

import java.util.List;

/**
 * Custom implementation of {@link java.util.Stack}.
 * This is a basic implementation for learning purpose and not an industry standard version of {@link java.util.Stack}.
 * @param <T> Type of items the Stack can store
 * @author Sarvesh-D
 */
public class MyStack<T> {

    private final MyLinkedList<T> stack;

    public MyStack(T top) {
        this.stack = new MyLinkedList<>(top);
    }

    /**
     * Inserts the item at top of the {@link MyStack}
     * @param item to insert
     */
    public void push(T item) {
        stack.append(item);
    }

    /**
     * Removes and returns the item at top of the {@link MyStack}
     * @return item at top of the Stack
     * @implNote Uses {@link MyStack#top()}
     */
    public T pop() {
        T item = top();
        stack.removeHead();
        return item;
    }

    /**
     * Returns if the {@link MyStack} is empty or not.
     * @return <code>true</code> if this Stack is empty, <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return stack.asList()
                    .size() == 0;
    }

    /**
     * Returns the element at top of the {@link MyStack}. This method does not remove the item from the stack,
     * to remove the item use {@link MyStack#pop()}.
     * @return item at top of this Stack
     */
    public T top() {
        return stack.head();
    }

    public List<T> asList() {
        return stack.asList();
    }

    @Override
    public String toString() {
        return asList().toString();
    }
}
