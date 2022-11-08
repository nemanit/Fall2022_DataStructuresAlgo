/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {

        // given head is a null, return null
        if (head == null) {
            return null;
        }

        return recursiveListToBST(head, null);
    }

    private TreeNode recursiveListToBST(ListNode startNode, ListNode endNode) {
        ListNode singleStepNode = startNode;
        ListNode doubleStepNode = startNode;

        // if both of the nodes converge, return null
        if (startNode == endNode) {
            return null;
        }

        while (doubleStepNode!=endNode && doubleStepNode.next!=endNode) {
            doubleStepNode = doubleStepNode.next.next;
            singleStepNode = singleStepNode.next;
            // need not worry about reaching a null when using next as the while condition fails when endNode which will be taking care of the end of LinkedList.
        }

        TreeNode desiredNode = new TreeNode(singleStepNode.val);
        desiredNode.left = recursiveListToBST(startNode, singleStepNode);
        ListNode newStartNode = singleStepNode.next;
        desiredNode.right = recursiveListToBST(newStartNode, endNode);
        return desiredNode;
    }
}