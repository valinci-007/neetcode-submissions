/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    Integer maxVal;

    public Pair (TreeNode node, int maxval) {
        this.node = node;
        this.maxVal = maxval;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, root.val));

        int ans = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.peek().node;
            int maxVal = q.peek().maxVal;
            q.remove();

            if (node.val >= maxVal) {
                ans++;
            }

            if (node.left != null) {
                q.offer(new Pair(node.left, Math.max (maxVal, node.val)));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, Math.max (maxVal, node.val)));
            }
        }

        return ans;
    }
}
