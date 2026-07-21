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

    public boolean isValidBST(TreeNode root) {

        // Initially, every value is allowed
        // Range = (-∞, +∞)
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {

        // Empty tree is always a valid BST
        if (root == null)
            return true;

        // Current node must lie within the allowed range
        // BST does NOT allow duplicates
        if (root.val <= min || root.val >= max)
            return false;

        // Left subtree:
        // Values must be smaller than current node
        boolean leftSubtree = validate(root.left, min, root.val);

        // Right subtree:
        // Values must be greater than current node
        boolean rightSubtree = validate(root.right, root.val, max);

        // BST is valid only if BOTH subtrees are valid
        return leftSubtree && rightSubtree;
    }
}