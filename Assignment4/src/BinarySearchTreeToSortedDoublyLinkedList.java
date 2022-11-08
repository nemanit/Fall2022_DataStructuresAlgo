/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    public Node firstNode = null;
    public Node lastNode = null;

    public Node treeToDoublyList(Node root) {

        // simple condition to check if given root is null
        if (root == null) {
            return null;
        }

        recursiveDFS(root);

        // making it a double linked list
        firstNode.left = lastNode;
        lastNode.right = firstNode;

        return firstNode;

    }

    private void recursiveDFS(Node node) {

        if (node != null) {

            // DFS to the left most left of the tree to start the double linked list

            recursiveDFS(node.left);
            if (lastNode == null) {
                // hit this condition when the DFS algo has the left mose leaf of tree
                firstNode = node;

            } else {
                lastNode.right = node;
                node.left = lastNode;
            }

            lastNode = node;

            // build on right leafs of nodes of the tree

            recursiveDFS(node.right);
        }


    }
}