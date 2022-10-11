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
    public boolean isSymmetric(TreeNode root) {

        return centerLeftRightAreSymmetric(root, root);

    }

    public boolean centerLeftRightAreSymmetric(TreeNode leftNode, TreeNode rightNode) {

        // Case 1: if both left and right nodes are null
        if (leftNode == null && rightNode == null) {
            return true;
        }

        // Case 2: only one of the left or right nodes is null
        if (leftNode == null || rightNode == null) {
            return false;
        }

        // Case 3: left and right nodes values should be and left node's right node
        // equal to right node's left node and left node's left node equal to
        // right node's right node
        return (leftNode.val == rightNode.val) && centerLeftRightAreSymmetric(leftNode.left, rightNode.right) && centerLeftRightAreSymmetric(leftNode.right, rightNode.left);
    }
}