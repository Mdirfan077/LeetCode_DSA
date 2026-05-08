import java.util.*;

class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;

        // Map prime -> list of indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build factor map
        for (int i = 0; i < n; i++) {
            Set<Integer> factors = getPrimeFactors(nums[i]);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        // To avoid reusing same prime teleportation many times
        Set<Integer> usedPrime = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // Adjacent left
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Adjacent right
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // Prime teleportation
                if (isPrime(nums[idx]) && !usedPrime.contains(nums[idx])) {

                    int p = nums[idx];

                    if (map.containsKey(p)) {

                        for (int next : map.get(p)) {

                            if (!visited[next]) {
                                visited[next] = true;
                                q.offer(next);
                            }
                        }
                    }

                    usedPrime.add(p);
                }
            }

            steps++;
        }

        return -1;
    }

    // Check prime
    private boolean isPrime(int x) {
        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }

    // Get unique prime factors
    private Set<Integer> getPrimeFactors(int x) {

        Set<Integer> set = new HashSet<>();

        for (int i = 2; i * i <= x; i++) {

            while (x % i == 0) {
                set.add(i);
                x /= i;
            }
        }

        if (x > 1) set.add(x);

        return set;
    }
}