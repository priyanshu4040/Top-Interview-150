/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: empty list or single node is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode mid = getMiddle(head);

        // Split the list into two halves
        ListNode rightHead = mid.next;
        mid.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Finds the middle node (left middle for even-length lists)
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merges two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }
}
