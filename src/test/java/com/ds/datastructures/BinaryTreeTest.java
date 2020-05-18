
package com.ds.datastructures;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void insert() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        ints.print();
        Optional<BinaryTree<Integer>> node = ints.search(3);
        assertThat(node).isNotEmpty();
        assertThat(node.get()
                       .getLeft()
                       .equals(new BinaryTree<>(2)));
        assertThat(node.get()
                       .getRight()
                       .equals(new BinaryTree<>(5)));
    }

    @Test
    public void search() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        assertThat(ints.search(5)).isNotEmpty();
        assertThat(ints.search(10)).isNotEmpty();
        assertThat(ints.search(11)).isNotEmpty();
        assertThat(ints.search(4)).isEmpty();
    }

    @Test
    public void remove() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        assertThat(ints.search(10)).isNotEmpty();
        ints.print();
        ints.remove(10);
        assertThat(ints.search(10)).isEmpty();
        assertThat(ints.search(11)).isEmpty();
        ints.print();
    }
}
