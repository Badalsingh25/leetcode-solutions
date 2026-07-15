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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        ListNode pA = l1;
        ListNode pB = l2;

        while (pA != null || pB != null || carry != 0) {
            if (pA != null) {
                carry += pA.val;
                pA = pA.next;
            }
            if (pB != null) {
                carry += pB.val;
                pB = pB.next;
            }
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry /= 10;
        }
        return dummy.next;
    }
}