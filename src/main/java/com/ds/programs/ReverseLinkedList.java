
package com.ds.programs;

import com.ds.datastructures.MyLinkedList;
import com.ds.datastructures.MyStack;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Program to reverse a {@link java.util.LinkedList}
 */
public class ReverseLinkedList {

    public static <T> LinkedList<T> solution(LinkedList<T> input) {
        Stack<T> inputS = new Stack<>();
        LinkedList<T> output = new LinkedList<>();
        for (T t : input)
            inputS.push(t);
        for (T t : inputS)
            output.add(inputS.pop());
        return output;
    }

    public <T> MyLinkedList<T> solution(MyLinkedList<T> input) {
        MyLinkedList<T> output = new MyLinkedList<>(input.tail());

        return output;
    }

}
