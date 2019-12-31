package com.ds.codility;

import java.util.Stack;

public class VoraciousFish {

    public static int voraciousFish(int[] A, int[] B) {
        Stack<Integer> rightMovingFishes = new Stack<>();
        int survivors = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                rightMovingFishes.add(A[i]);
            } else {
                while (!rightMovingFishes.isEmpty()) {
                    int rWeight = rightMovingFishes.pop();
                    if (A[i] < rWeight) {
                        rightMovingFishes.push(rWeight);
                        break;
                    }
                }
                if (rightMovingFishes.isEmpty())
                    survivors++;
            }
        }
        return survivors + rightMovingFishes.size();
    }

}
