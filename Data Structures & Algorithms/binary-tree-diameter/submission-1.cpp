/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        int best = 0;
        diameter(root, best);
        return best;
    }

    int diameter(TreeNode* node, int& best){
        if(node==nullptr) return 0;

        int L = diameter(node->left, best);
        int R = diameter(node->right, best);

        best = max(best, L+R);

        return 1 + max(L, R);
    }
};
