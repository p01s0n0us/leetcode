package com.p01s0n0us.leetcode.valid_palindrome_ii;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}


class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int cnt = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                boolean matched = true;
                int l = i + 1;
                int r = j;

                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        matched = false;
                        break;
                    }
                    l++;
                    r--;
                }

                if (matched) {
                    return true;
                }

                matched = true;
                l = i;
                r = j - 1;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        matched = false;
                        break;
                    }
                    l++;
                    r--;
                }

                return matched;
            }

            i++;
            j--;
        }

        return true;
    }
}