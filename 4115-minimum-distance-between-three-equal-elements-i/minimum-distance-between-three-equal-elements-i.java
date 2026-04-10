import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> list = map.get(nums[i]);

            list.add(i);

            // check last 3 occurrences
            if (list.size() >= 3) {
                int size = list.size();

                int first = list.get(size - 3);
                int third = list.get(size - 1);

                int distance = 2 * (third - first); // ✅ FIXED

                ans = Math.min(ans, distance);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}