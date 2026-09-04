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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int k = len - n;

        ListNode prev = null;
        curr = head;

        while (k > 0) {
            prev = curr;
            curr = curr.next;
            k--;
        }

        // curr is pointing to the node which we have to remove
        if (prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;
        return head;
    }
}
