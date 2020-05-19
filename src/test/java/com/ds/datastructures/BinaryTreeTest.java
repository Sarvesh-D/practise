
package com.ds.datastructures;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    public void max() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        assertThat(ints.max()).isNotEmpty()
                              .get()
                              .isEqualTo(11);
    }

    @Test
    public void min() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        assertThat(ints.min()).isNotEmpty()
                              .get()
                              .isEqualTo(2);
    }

    @Test
    public void height() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        ints.print();
        assertThat(ints.height()).isEqualTo(2);
        assertThat(ints.search(11)
                       .get()
                       .height()).isEqualTo(0);
    }

    @Test
    public void traverse() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                                                      .insert(5)
                                                      .insert(2)
                                                      .insert(10)
                                                      .insert(11);
        ints.print();
        assertThat(ints.traverse(BinaryTree.TraverseMode.LEVEL_ORDER)).containsExactly(5, 3, 10, 2, 5, 11);
        assertThat(ints.traverse(BinaryTree.TraverseMode.IN_ORDER)).containsExactly(2,3,5,5,10,11);
        assertThat(ints.traverse(BinaryTree.TraverseMode.PRE_ORDER)).containsExactly(5, 3, 2, 5, 10, 11);
        //assertThat(ints.traverse(BinaryTree.TraverseMode.POST_ORDER)).containsExactly(2,3);

        System.out.println(ints.traverse(BinaryTree.TraverseMode.LEVEL_ORDER));
        System.out.println(ints.traverse(BinaryTree.TraverseMode.IN_ORDER));
        System.out.println(ints.traverse(BinaryTree.TraverseMode.PRE_ORDER));
        System.out.println(ints.traverse(BinaryTree.TraverseMode.POST_ORDER));


    }

    @Test
    public void delete() {
        BinaryTree<Integer> ints = new BinaryTree<>(5).insert(3)
                .insert(4)
                .insert(2)
                .insert(10)
                .insert(11);
        ints.print();
        ints.delete(2);
        assertThat(ints.search(2)).isEmpty();
        ints.print();
        ints.insert(2);
        assertThat(ints.search(2)).isNotEmpty();
        ints.print();
        ints.delete(10);
        assertThat(ints.search(10)).isEmpty();
        ints.print();
        ints.insert(10);
        assertThat(ints.search(10)).isNotEmpty();
        ints.print();
        ints.delete(11);
        assertThat(ints.search(11)).isEmpty();
        ints.print();
    }
}
