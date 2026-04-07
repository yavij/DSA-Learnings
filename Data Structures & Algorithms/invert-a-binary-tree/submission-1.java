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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        return heightTree(root);
    }

    private TreeNode heightTree(TreeNode root){
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        heightTree(root.left);
        heightTree(root.right);    
        return root;
    }
}
