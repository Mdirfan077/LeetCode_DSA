import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Map value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            // If only one occurrence
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            // Binary search
            int pos = Collections.binarySearch(list, idx);
            int m = list.size();

            int left = list.get((pos - 1 + m) % m);
            int right = list.get((pos + 1) % m);

            int d1 = Math.min(Math.abs(idx - left), n - Math.abs(idx - left));
            int d2 = Math.min(Math.abs(idx - right), n - Math.abs(idx - right));

            result.add(Math.min(d1, d2));
        }

        return result;
    }
}