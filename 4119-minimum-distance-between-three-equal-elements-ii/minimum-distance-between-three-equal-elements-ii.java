import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayDeque<>());
            Deque<Integer> dq = map.get(nums[i]);

            dq.addLast(i);

            // Keep only last 3 indices
            if (dq.size() > 3) {
                dq.pollFirst();
            }

            // When we have 3 occurrences
            if (dq.size() == 3) {
                int first = dq.peekFirst();
                int last = dq.peekLast();

                int distance = 2 * (last - first); // ✅ important

                ans = Math.min(ans, distance);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}