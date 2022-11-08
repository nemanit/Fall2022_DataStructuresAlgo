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

    ArrayList<Integer> nodeValuesinOrderDFS;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(root == null) {
            return root;
        }

        nodeValuesinOrderDFS = new ArrayList<Integer>();
        inorderDFSTraversal(root);


        for (int i = 0; i < nodeValuesinOrderDFS.size(); i++) {
            if(nodeValuesinOrderDFS.get(i) == p.val) {
                if(i < nodeValuesinOrderDFS.size() - 1) {
                    return new TreeNode(nodeValuesinOrderDFS.get(i+1));
                } else {
                    return null;
                }
            }
        }
        return null;
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