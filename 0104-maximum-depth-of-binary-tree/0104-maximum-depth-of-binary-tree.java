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
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        
        if(root != null){
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            maxDepth = Math.max(leftHeight, rightHeight) + 1;
        }
        return maxDepth;
    }
}