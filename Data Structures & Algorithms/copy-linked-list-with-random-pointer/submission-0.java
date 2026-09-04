/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node node = new Node (curr.val);
            oldToNew.put (curr, node);
            curr = curr.next;
        }

        for (Map.Entry<Node, Node> entry : oldToNew.entrySet()) {
            Node oldNode = entry.getKey();
            Node newNode = entry.getValue();

            newNode.next = oldToNew.getOrDefault(oldNode.next, null);
            newNode.random = oldToNew.getOrDefault(oldNode.random, null);
        }

        return oldToNew.get(head);
    }
}
