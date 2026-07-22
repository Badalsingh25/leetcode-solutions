/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both nodes are in the left subtree
            if (p.val < root.val && q.val < root.val)
                root = root.left;

            // Both nodes are in the right subtree    
            else if (p.val > root.val && q.val > root.val)
                root = root.right;

            // split point(or one node is at current node)
            else
                return root;
        }
        // This line is never reached for valid inputs,
        // but Java requires a return statement.
        return null;
    }
}