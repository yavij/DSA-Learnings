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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        buildSerializer(root, data);
        return data.toString();
    }

    private void buildSerializer(TreeNode root, StringBuilder data){
        if(root == null){
            data.append("null_");
            return;
        }
        data.append(root.val+"_");
        buildSerializer(root.left, data);
        buildSerializer(root.right, data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);

        return node;
    }
}
