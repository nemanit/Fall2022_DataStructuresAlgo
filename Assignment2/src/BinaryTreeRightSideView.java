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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList();

        List<TreeNode> nodesTraversed = new ArrayList();
        if (root != null) {
            nodesTraversed.add(root);
        }
        // case 1: if the given tree is an empty tree, return empty list
        else {
            return result;
        }

        int lengthOfNodesTraversed = nodesTraversed.size();
        while(lengthOfNodesTraversed != 0) {

            // case 2: always add the right most node in the nodestraversed array
            int rightmoseNodeInNodesTraversed = nodesTraversed.get(lengthOfNodesTraversed-1).val;
            result.add(rightmoseNodeInNodesTraversed);

            List<TreeNode> nodesToTraverse = new ArrayList();

            for(TreeNode singleNode: nodesTraversed) {
                if (singleNode.left != null) {
                    nodesToTraverse.add(singleNode.left);
                }

                if (singleNode.right != null) {
                    nodesToTraverse.add(singleNode.right);
                }
            }

            nodesTraversed = nodesToTraverse;
            lengthOfNodesTraversed = nodesTraversed.size();
        }

        return result;

    }
}