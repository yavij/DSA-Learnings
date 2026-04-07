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

    Map<Integer, List<Integer>> levelValues = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        levelValues.clear();          // important if reused
        rootLevels(root, 0);          // start from level 0

        List<List<Integer>> results = new ArrayList<>();

        // collect in correct order (0 → max level)
        for (int i = 0; i < levelValues.size(); i++) {
            results.add(levelValues.get(i));
        }

        return results;
    }

    private void rootLevels(TreeNode root, int level) {
        if (root == null) return;

        List<Integer> values = levelValues.getOrDefault(level, new ArrayList<>());
        values.add(root.val);
        levelValues.put(level, values);

        rootLevels(root.left, level + 1);
        rootLevels(root.right, level + 1);
    }
}
