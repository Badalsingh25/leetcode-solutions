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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Base Case 1:
        // If both nodes are null, both trees ended at the same place.
        // Hence, they are identical.
        if (p == null && q == null)
            return true;

        // Base Case 2:
        // If only one node is null, the tree structures are different.
        // Hence, the trees cannot be identical.
        if (p == null || q == null)
            return false;

        // Base Case 3:
        // Both nodes exist, but their values are different.
        // Therefore, the trees are not the same.
        if (p.val != q.val)
            return false;

        // Recursive Case:
        // We have already confirmed:
        // 1. Both nodes exist.
        // 2. Their values are equal.
        //
        // Now compare:
        // 1. Their left subtrees.
        // 2. Their right subtrees.
        //
        // Both comparisons must be true for the trees to be identical.
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}