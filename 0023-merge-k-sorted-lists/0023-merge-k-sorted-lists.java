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
/*
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {

       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

       for (int i = 0; i < lists.length; i++) {
           if (lists[i] != null)
               minHeap.offer(lists[i]);
       }
       ListNode dummy = new ListNode(0);
       ListNode current = dummy;

       while (!minHeap.isEmpty()) {
           ListNode node = minHeap.poll();

           current.next = node;
           current = current.next;

           if (node.next != null) {
               minHeap.offer(node.next);
           }
       }
       return dummy.next;
   }
}
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];

        int mid = left + (right - left) / 2;
        ListNode leftList = mergeSort(lists, left, mid);
        ListNode rightList = mergeSort(lists, mid + 1, right);

        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null)
            current.next = l1;
        if (l2 != null)
            current.next = l2;

        return dummy.next;
    }
}