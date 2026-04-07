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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0 || inorder.length == 0) return null;
      int preorderStart = 0;
      int preorderEnds = preorder.length-1;
      int inorderStart = 0;
      int inorderEnd = inorder.length-1;
      return traversal(preorder, preorderStart, preorderEnds, 
      inorder, inorderStart, inorderEnd);
    }

    private TreeNode traversal(int[] preorder, int preorderStart, int preorderEnds, 
    int[] inorder, int inorderStart, int inorderEnd){
        if (preorderStart > preorderEnds || inorderStart > inorderEnd)
        return null;
        TreeNode node = new TreeNode(preorder[preorderStart]);
        int rootIndex = inorderStart;
        while (inorder[rootIndex] != node.val) {
            rootIndex++;
        }
        int leftSize = rootIndex - inorderStart;
        node.left = traversal(preorder,preorderStart + 1, preorderStart + leftSize,
        inorder, inorderStart, rootIndex - 1);
        node.right = traversal(  preorder, preorderStart + leftSize + 1, preorderEnds,
        inorder, rootIndex + 1, inorderEnd);
       return node;
    }
}
