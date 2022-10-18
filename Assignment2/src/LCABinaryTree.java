/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // if given root is null, return root
        if (root == null ) {
            return root;
        }

        // if given p or q are equal to root, then return root
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // found no common ancestor
        if(leftLCA == null && rightLCA == null) {
            return null;
        }

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA == null) {
            return rightLCA;
        } else {
            return leftLCA;
        }
    }
}