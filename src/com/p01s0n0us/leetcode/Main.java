package com.p01s0n0us.leetcode;

import java.util.*;

public class Main {

    public static final Set<String> RES = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Stack<Character> stack = new Stack<>();

        dfs(stack, s, 0, new ArrayList<>());
        System.out.println("---");
        for (String re : RES) {
            System.out.println(re);
        }

    }


    public static void dfs(Stack<Character> stack, String s, Integer index, List<Character> ans) {
        if (ans.size() == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            ans.forEach(stringBuilder::append);
            System.out.println(stringBuilder.toString());
            RES.add(stringBuilder.toString());
            return;
        }

        Stack<Character> copy = new Stack<>();
        while (!stack.isEmpty()) {
            Character temp = stack.pop();
            copy.push(temp);

            ans.add(temp);
            dfs(stack, s, index, ans);
            ans.remove(ans.size() - 1);
        }

        while (!copy.isEmpty()) {
            stack.push(copy.pop());
        }

        if (index < s.length()) {
            // 直接卖出
            ans.add(s.charAt(index));
            dfs(stack, s, index + 1, ans);
            ans.remove(ans.size() - 1);

            // 当前不卖出
            stack.push(s.charAt(index));
            dfs(stack, s, index + 1, ans);
            stack.pop();
        }

    }

}
