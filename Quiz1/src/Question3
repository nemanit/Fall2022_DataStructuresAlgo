
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> currentLevelQueue = new ArrayDeque<>();
        currentLevelQueue.add(root);

        while (!currentLevelQueue.isEmpty()) {
            int levelQueueSize = currentLevelQueue.size();
            List<Integer> currentlevelElements = new ArrayList<>();

            for (int i = 0; i < levelQueueSize; i++) {
                TreeNode node = currentLevelQueue.removeFirst();
                currentlevelElements.add(node.val);

                if (node.left != null)
                    currentLevelQueue.addLast(node.left);

                if (node.right != null)
                    currentLevelQueue.addLast(node.right);
            }
            result.add(currentlevelElements);
        }

        return result;
    }
}