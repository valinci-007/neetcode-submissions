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
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> hash = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            if (hash.containsKey(curr)) {
                return true;
            }

            hash.put(curr, true);
            curr = curr.next;
        }

        return false;
    }
}
