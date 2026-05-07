import java.util.*;

class Solution {

    static class Component {
        int maxVal;
        int left;
        int right;

        Component(int maxVal, int left, int right) {
            this.maxVal = maxVal;
            this.left = left;
            this.right = right;
        }
    }

    public int[] maxValue(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        Stack<Component> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            Component curr = new Component(nums[i], i, i);

            // Merge connected components
            while (!stack.isEmpty() &&
                   stack.peek().maxVal > nums[i]) {

                Component top = stack.pop();

                curr = new Component(
                        Math.max(curr.maxVal, top.maxVal),
                        top.left,
                        curr.right
                );
            }

            stack.push(curr);
        }

        // Fill answers
        while (!stack.isEmpty()) {

            Component c = stack.pop();

            for (int i = c.left; i <= c.right; i++) {
                ans[i] = c.maxVal;
            }
        }

        return ans;
    }
}