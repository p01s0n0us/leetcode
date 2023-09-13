package com.p01s0n0us.leetcode.count_good_numbers;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        BigDecimal.valueOf(20).pow(7).multiply(BigDecimal.valueOf(5)).divideAndRemainder(new BigDecimal(1000000007));


        System.out.println(new Solution().countGoodNumbers(15));

        System.out.println(BigDecimal.valueOf(20));
    }
}

class Solution {

//    public static final Map<Long, Map<Long, Long>> cache = new HashMap<>();

    public int countGoodNumbers(long n) {

        long ans = 0;
        if (n % 2 == 0) {
            ans = pow0(20, n / 2);
        } else {
            ans = pow0(20, (n - 1) / 2) * 5L % 1000000007;
        }
        return (int) ans;
    }


    public long pow0(long a, long b) {
        long res = 1, mul = a;
        while (b >= 1) {
            if (b % 2 == 1) {
                res = res * mul % 1000000007;
            }

            mul = mul * mul % 1000000007;

            b = b / 2;
        }

        return res;

    }
//
//    public long pow(long a, long b) {
//        if (cache.containsKey(a) && cache.get(a).containsKey(b)) {
//            return cache.get(a).get(b);
//        }
//
//        if (b <= 6) {
//            long res = (long) (Math.pow(20, b) % 1000000007);
//            cache.get(a).put(b, res);
//            return res;
//        } else {
//            long res;
//            if (b % 2 != 0) {
//                res = pow(a, b / 2) * pow(a, b / 2) % 1000000007 * a % 1000000007;
//            } else {
//                res = pow(a, b / 2) * pow(a, b / 2) % 1000000007;
//            }
//            cache.get(a).put(b, res);
//            return res;
//        }
//
//    }

}

