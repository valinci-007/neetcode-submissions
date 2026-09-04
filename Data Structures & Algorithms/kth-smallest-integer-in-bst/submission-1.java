class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {          // dive to the leftmost
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();             // smallest unvisited
            if (--k == 0) return node.val;  // kth in-order → done
            node = node.right;
        }
        return -1;   // k guaranteed valid, unreachable
    }
}