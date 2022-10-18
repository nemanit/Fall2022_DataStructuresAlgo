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
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int maxDepth=1;
        Queue<TreeNode> treeNodeListQueue = new LinkedList<TreeNode>();
        Queue<Integer> integerListQueue = new LinkedList<Integer>();

        treeNodeListQueue.add(root);
        integerListQueue.add(1);

        int treeListQueueSize = treeNodeListQueue.size();

        while( treeListQueueSize > 0){

            int initialIntegerListQueue = integerListQueue.peek();

            for(int i = 0; i < treeListQueueSize; i++) {

                TreeNode initialTreeNode = treeNodeListQueue.remove();
                int currentDepth = integerListQueue.remove();

                if(initialTreeNode.left!=null) {
                    treeNodeListQueue.add(initialTreeNode.left);
                    integerListQueue.add(2*currentDepth);
                }
                if(initialTreeNode.right!=null) {
                    treeNodeListQueue.add(initialTreeNode.right);
                    integerListQueue.add(2*currentDepth+1);
                }

                maxDepth=Math.max(maxDepth,currentDepth-initialIntegerListQueue+1);
            }
            treeListQueueSize = treeNodeListQueue.size();
        }
        return maxDepth;
    }
}