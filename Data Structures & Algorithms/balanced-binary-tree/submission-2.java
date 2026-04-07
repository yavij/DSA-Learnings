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
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = isBalancedHeight(root.left);
        int right = isBalancedHeight(root.right);
        isBalanced(root.left);
        isBalanced(root.right);
        return isBalanced(root.left) && Math.abs(left-right) <= 1 && isBalanced(root.right);
    }

    private int isBalancedHeight(TreeNode root){
        if(root == null) return 0;
        int left = isBalancedHeight(root.left);
        int right = isBalancedHeight(root.right);
        return 1 + Math.max(left, right);
    }

}
