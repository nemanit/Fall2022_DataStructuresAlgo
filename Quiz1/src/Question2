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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if given trees are null
        if (p == null && q == null) {
            return true;
        }
        // if p is null and q is not null
        else if (p == null && q != null) {
            return false;
        }
        // if q is null and p is not null
        else if (p != null && q == null) {
            return false;
        }
        // if both of the p and q values are different
        else if (p.val != q.val) {
            return false;
        }

        boolean left_tree_condition = isSameTree(p.left, q.left);
        boolean right_tree_condition = isSameTree(p.right, q.right);

        return (left_tree_condition && right_tree_condition);

    }
}