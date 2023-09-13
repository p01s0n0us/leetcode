package com.p01s0n0us.leetcode.course_schedule_iv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Boolean> booleans = new Solution().checkIfPrerequisite(
                3,
                new int[][]{
                        {1, 2},
                        {1, 0},
                        {2, 0}
                },
                new int[][]{
                        {1, 0},
                        {1, 2}
                }
        );

        System.out.printf(booleans.toString());
    }
}

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];

            graph.get(from).add(to);
        }

        List<Set<Integer>> cache = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            cache.add(i, new HashSet<>());
        }

        boolean[] initialized = new boolean[numCourses];

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];

            if (!initialized[from]) {
                init(graph, cache, initialized, from);
            }
            ans.add(cache.get(from).contains(to));
        }

        return ans;

    }

    private void init(List<List<Integer>> graph, List<Set<Integer>> cache, boolean[] initialized, int from) {
        if (initialized[from]) {
            return;
        }

        initialized[from] = true;
        if (graph.get(from).isEmpty()) {
            cache.get(from).add(from);
        }

        for (Integer next : graph.get(from)) {
            init(graph, cache, initialized, next);
            cache.get(from).addAll(cache.get(next));
            cache.get(from).add(next);

        }
    }

}