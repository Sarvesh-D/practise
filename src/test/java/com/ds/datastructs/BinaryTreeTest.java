package com.ds.datastructs;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testInsert() {
        BinaryTree bt = new BinaryTree(5);
        // Arrays.stream(TestUtils.randomIntArr(5, -10, 20, false)).forEach(bt::insert);
        bt.insert(3)
          .insert(5)
          .insert(2)
          .insert(10)
          .insert(11)
          .insert(4)
          .insert(9)
          .print();
    }

}
