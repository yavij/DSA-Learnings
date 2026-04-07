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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        treeValues(root, 0, values);
        return values;
    }

    private void treeValues(TreeNode root, int levels, List<Integer> values){
        if(root == null) return;
        if(levels == values.size()){
            values.add(root.val);
        }
        treeValues(root.right, levels+1, values);
        treeValues(root.left, levels+1, values);
    }
}
