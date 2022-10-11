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
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> columnNodesmap = new HashMap<>();
        Queue<TreeNode> nodesTraversed = new LinkedList<>();
        Queue<Integer> columnsOrdered = new LinkedList<>();

        if (root != null) {
            nodesTraversed.add(root);
            columnsOrdered.add(0);
        }
        else {
            return result;
        }

        int min = 0;
        int max = 0;

        int lengthOfNodesTraversed = nodesTraversed.size();

        while(lengthOfNodesTraversed != 0) {
            TreeNode singleNodeTraveresed = nodesTraversed.poll();
            int columnOrder = columnsOrdered.poll();
            if(!columnNodesmap.containsKey(columnOrder)) columnNodesmap.put(columnOrder, new ArrayList<Integer>());

            columnNodesmap.get(columnOrder).add(singleNodeTraveresed.val);

            if(singleNodeTraveresed.left != null){
                nodesTraversed.add(singleNodeTraveresed.left);
                columnsOrdered.add(columnOrder-1);
                min = Math.min(min, columnOrder - 1);
            }

            if(singleNodeTraveresed.right != null){
                nodesTraversed.add(singleNodeTraveresed.right);
                columnsOrdered.add(columnOrder+1);
                max = Math.max(max, columnOrder + 1);
            }

            lengthOfNodesTraversed = nodesTraversed.size();
        }

        for (int i = min; i <= max; i++) {
            result.add(columnNodesmap.get(i));
        }

        return result;

    }
}