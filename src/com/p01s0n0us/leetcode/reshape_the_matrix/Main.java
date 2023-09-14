package com.p01s0n0us.leetcode.reshape_the_matrix;

public class Main {
}

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;


        if (m * n != r * c) {
            return mat;
        }

        int[][] trans = new int[r][c];

        int idxR = 0, idxC = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                trans[idxR][idxC++] = ints[j];

                if (idxC == c) {
                    idxR++;
                    idxC = 0;
                }
            }
        }

        return trans;
    }
}