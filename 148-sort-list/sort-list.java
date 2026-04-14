/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split list into two halves
        ListNode mid = slow.next;
        slow.next = null;

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return dummy.next;
    }
}