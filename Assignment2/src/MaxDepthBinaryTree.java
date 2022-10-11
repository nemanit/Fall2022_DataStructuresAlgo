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
    public int maxDepth(TreeNode root) {

        // Case 1: if given treeNode is null, length is 0
        if (root == null) {
            return 0;
        }

        // recursive depth search to find length of left and right trees of each node
        int leftNodeDepth = maxDepth(root.left);
        int rightNodeDepth = maxDepth(root.right);

        // we need to add +1 to the depth to include the node depth itself
        // Case 2: if leftNodeDepth is greater than rightNodeDepth
        if (leftNodeDepth > rightNodeDepth) {
            return (leftNodeDepth + 1);
        }
        // Case 3: if rightNodeDepth is greater than leftNodeDepth
        else {
            return (rightNodeDepth + 1);
        }
    }
}