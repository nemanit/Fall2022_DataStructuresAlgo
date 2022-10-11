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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        List<TreeNode> nodesTraversed = new ArrayList();
        if (root != null) {
            nodesTraversed.add(root);
        }
        // case 1: if the given tree is an empty tree, return empty list
        else {
            return result;
        }

        boolean zigzagOrder = true;

        int lengthOfNodesTraversed = nodesTraversed.size();
        while(lengthOfNodesTraversed != 0) {

            LinkedList<Integer> subResult = new LinkedList<>();

            for(int i = 0; i < lengthOfNodesTraversed; i++) {
                // case 2: add elements in zigzag order
                if(zigzagOrder) {
                    subResult.add(nodesTraversed.get(i).val);
                }
                // case 3: add elements in opposite zigzag order
                else {
                    subResult.addFirst(nodesTraversed.get(i).val);
                }
            }

            result.add(subResult);

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
            zigzagOrder = !zigzagOrder;
        }

        return result;

    }
}