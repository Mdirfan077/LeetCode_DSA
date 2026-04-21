import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        // Step 1: Union-Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }

        // Step 2: Group indices
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int result = 0;

        // Step 3: Process each group
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();

            // Count source values
            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            // Match with target
            for (int idx : group) {
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    result++; // mismatch
                }
            }
        }

        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}