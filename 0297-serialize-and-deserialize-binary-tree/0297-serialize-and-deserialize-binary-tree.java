/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val)
                .append(',');

        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int index = 0;

    public TreeNode deserialize(String data) {

        String[] tokens = data.split(",");
        index = 0;

        return build(tokens);
    }

    private TreeNode build(String[] tokens) {

        String token = tokens[index++];

        if (token.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(token));

        root.left = build(tokens);
        root.right = build(tokens);

        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));