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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            Integer rightSide = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                rightSide = node.val; 

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add (rightSide);
        }

        return res;
    }
}
