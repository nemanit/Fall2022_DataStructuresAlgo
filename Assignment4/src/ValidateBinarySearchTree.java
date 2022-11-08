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
    public boolean isValidBST(TreeNode root) {

        return recursiveBST(null, root, null);
    }

    private boolean recursiveBST(TreeNode leftNode, TreeNode node, TreeNode rightNode) {

        // reached the leaf leaves or if given root is null
        if (node == null) {
            return true;
        }

        // check the left node condition that it should be smaller

        if (leftNode != null && leftNode.val >= node.val) {
            return false;
        }

        if (rightNode != null && rightNode.val <= node.val) {
            return false;
        }

        return (recursiveBST(leftNode, node.left, node) && recursiveBST(node, node.right, rightNode));
    }
}