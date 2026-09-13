/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Find whether a cycle exists
        while (fast != null && fast.next != null) {

            slow = slow.next; // move 1 step
            fast = fast.next.next; // move 2 step

            // If both meet, a cycle exists, the find the starting point
            if (slow == fast) {
                slow = head;

                // Move both equally
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast; // starting point found
            }
        }
        return null; // starting point not found
    }
}