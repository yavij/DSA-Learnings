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

    public int goodNodes(TreeNode root) {
        return countNode(root, root.val);
    }

    private int countNode(TreeNode root, int maxSofar){
        if(root == null) return 0;
        int count = 0;
        if(root.val >= maxSofar){
            count+=1;
        }
        int newMax = Math.max(root.val, maxSofar);
        int left = countNode(root.left, newMax);
        int right = countNode(root.right, newMax);
        return count+left+right;
    }
}
