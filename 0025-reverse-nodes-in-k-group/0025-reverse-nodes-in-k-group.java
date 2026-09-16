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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupStart = dummy;

        while (true) {

            ListNode groupEnd = groupStart;

            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;

                if (groupEnd == null)
                    return dummy.next;
            }
            ListNode groupNext = groupEnd.next;
            ListNode oldGroupStart = groupStart.next;

            ListNode prev = groupNext;
            ListNode curr = groupStart.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            groupStart.next = groupEnd;
            groupStart = oldGroupStart;
        }
    }
}