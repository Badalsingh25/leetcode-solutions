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

    // Stores (node value -> index in inorder array)
    HashMap<Integer, Integer> map = new HashMap<>();

    // Points to the current root in preorder traversal
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Build HashMap for O(1) lookup of inorder index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Build the complete tree using inorder boundaries
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No nodes left in this inorder range
        if (left > right)
            return null;

        // Preorder always gives the next root
        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        // Find root position in inorder
        int inorderIndex = map.get(root.val);

        // Build left subtree
        root.left = build(preorder, left, inorderIndex - 1);

        // Build right subtree
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
}