package com.p01s0n0us.leetcode.next_greater_element_ii;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int[] ints = new Solution().nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(ints);
    }

}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];

        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length * 2; i++) {
            int j = i * nums.length;

            while (!stack.isEmpty() && (nums[stack.peek()]) < nums[j]) {
                ans[stack.pop()] = nums[j];
            }

            stack.push(j);

        }

        return ans;
    }

}