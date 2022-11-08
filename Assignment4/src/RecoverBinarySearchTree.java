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

    TreeNode nodeToCheck = null;
    TreeNode incorrectLargeTreeNode = null;
    TreeNode incorrectSmallTreeNode = null;


    public void recoverTree(TreeNode root) {

        // given tree is null, so no need to swap any elements
        if(root == null) {
            return;
        }

        dfsInorder(root);

        // The above dfsInorder should have filled values in incorrectLargeTreeNode and incorrectSmallTreeNode

        int temperoryValue = incorrectLargeTreeNode.val;
        incorrectLargeTreeNode.val = incorrectSmallTreeNode.val;
        incorrectSmallTreeNode.val = temperoryValue;
        return;
    }

    private void dfsInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsInorder(root.left);

        if(nodeToCheck != null && nodeToCheck.val > root.val) {
            if (incorrectLargeTreeNode == null) {
                incorrectLargeTreeNode = nodeToCheck;
            }
            incorrectSmallTreeNode = root;
        }


        nodeToCheck = root;
        dfsInorder(root.right);
    }
}