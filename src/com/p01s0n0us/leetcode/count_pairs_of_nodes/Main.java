package com.p01s0n0us.leetcode.count_pairs_of_nodes;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().countPairs(4, new int[][]{{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}}, new int[]{2, 3, 4});
    }
}


class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();


        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            degree[u]++;
            degree[v]++;

            cnt.put(u * n + v, cnt.getOrDefault(u * n + v, 0) + 1);
        }


        int[] copy = Arrays.copyOf(degree, n);
        Arrays.sort(copy);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            for (int j = 0; j < n; j++) {
                int l = j + 1;
                int r = n - 1;

                ans[i] += n - binarySearch(copy, l, r, queries[i] - copy[j]);
            }

            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int x = entry.getKey() / n;
                int y = entry.getKey() % n;

                if (degree[x] + degree[y] > queries[i] && degree[x] + degree[y] - entry.getValue() <= queries[i]) {
                    ans[i]--;
                }

            }


        }
        return ans;

    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
