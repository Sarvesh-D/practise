
package com.ds.datastructures;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<Integer> ints;

    @Before
    public void setUp() throws Exception {
        ints = new MyLinkedList<>(Lists.newArrayList(4, -1, 3, 1, 6, 9));
    }

    @After
    public void tearDown() throws Exception {
        ints = null;
    }

    @Test
    public void append() {
        ints.append(1)
            .append(5)
            .append(2)
            .append(3);
        assertThat(ints.asList()).containsExactly(4, -1, 3, 1, 6, 9, 1, 5, 2, 3);
        nodeAssert(ints.getNode(2), ints.getNode(1), ints.getNode(3));
    }

    @Test
    public void prepend() {
        ints.prepend(4)
            .prepend(2)
            .prepend(-5);
        assertThat(ints.asList()).containsExactly(-5, 2, 4, 4, -1, 3, 1, 6, 9);
    }

    @Test
    public void insert() {
        MyLinkedList.Node<Integer> nodeToInsert = new MyLinkedList.Node<>(7);
        ints.insert(nodeToInsert.getItem(), 2);
        assertThat(ints.asList()).containsExactly(4, -1, 7, 3, 1, 6, 9);
        nodeAssert(ints.getNode(2), ints.getNode(1), ints.getNode(3));
        nodeAssert(ints.getNode(3), nodeToInsert, new MyLinkedList.Node<>(1));
    }

    @Test
    public void remove() {

    }

    @Test
    public void testRemove() {
    }

    @Test
    public void removeHead() {
        ints.removeHead();
        assertThat(ints.getHead()).satisfies(head -> {
            assertThat(head.getNext()).isEqualTo(new MyLinkedList.Node<>(3));
            assertThat(head.getPrev()).isNull();
            assertThat(head.getItem()).isEqualTo(-1);
        });
    }

    @Test
    public void mid() {
    }

    @Test
    public void getNode() {
    }

    @Test
    public void get() {
        assertThat(ints.get(1)).isEqualTo(-1);
        assertThat(ints.tail()).isEqualTo(9);
        assertThat(ints.get(0)).isEqualTo(4);
        assertThat(ints.get(-1)).isEqualTo(ints.tail());
        assertThat(ints.get(2)).isEqualTo(3);

    }

    @Test
    public void head() {
    }

    @Test
    public void tail() {
    }

    @Test
    public void asList() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void pretty() {
    }

    @Test
    public void getHead() {
    }

    private static <T> void nodeAssert(MyLinkedList.Node<T> curr, MyLinkedList.Node<T> prev, MyLinkedList.Node<T> next) {
        assertThat(curr.getNext()).isEqualTo(next);
        assertThat(curr.getPrev()).isEqualTo(prev);
    }
}
