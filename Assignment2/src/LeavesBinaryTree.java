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
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public int dfs(TreeNode treeNode, List<List<Integer>> result) {

        if (treeNode == null) {
            return 0;
        }

        int leftTreeDepth = dfs(treeNode.left, result);
        int rightTreeDepth = dfs(treeNode.right, result);

        int maxDepth = Math.max(leftTreeDepth, rightTreeDepth);

        if (result.size() <= maxDepth) {
            result.add(new ArrayList<>());
        }

        result.get(maxDepth).add(treeNode.val);
        return maxDepth + 1;
    }

}