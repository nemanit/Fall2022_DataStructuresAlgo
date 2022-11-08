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

    ArrayList<Integer> nodeValuesinOrderDFS;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }

        nodeValuesinOrderDFS = new ArrayList<Integer>();
        inorderDFSTraversal(root);

        int sum = 0;

        for (int i = 0; i < nodeValuesinOrderDFS.size(); i++) {
            int nodeValue = nodeValuesinOrderDFS.get(i);

            if(nodeValue >= low && nodeValue <= high) {
                sum = sum + nodeValue;
            }
        }

        return sum;
    }

    private void inorderDFSTraversal(TreeNode root) {
        // if given tree is null or traversal reaches leaves
        if (root == null) {
            return;
        }
        inorderDFSTraversal(root.left);
        nodeValuesinOrderDFS.add(root.val);
        inorderDFSTraversal(root.right);
    }

}