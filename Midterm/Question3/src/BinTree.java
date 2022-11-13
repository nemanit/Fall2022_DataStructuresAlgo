package Question3.src;

import java.util.ArrayList;

public class BinTree<T> {
    public Question3.src.Node<T> root;

    public BinTree() {

    }

    ArrayList<Integer> nodeValuesinOrderDFS;

    // Time complexity: O(n) We only traverse through all nodes only once so it is O(n)
    // Space complexity: O(n) we store all node values in nodeValuesinOrderDFS
    public void rangeBST(Node<Integer> root, int low, int high) {
        if(root == null) {
            return;
        }

        nodeValuesinOrderDFS = new ArrayList<Integer>();
        inorderDFSTraversal(root);

        for (int i = 0; i < nodeValuesinOrderDFS.size(); i++) {
            int nodeValue = nodeValuesinOrderDFS.get(i);

            if(nodeValue >= low && nodeValue <= high) {
                System.out.println("The number: " + nodeValue + "is in range of low:" + low + " high: " + high);
            }
        }

        return;
    }

    private void inorderDFSTraversal(Node root) {
        // if given tree is null or traversal reaches leaves
        if (root == null) {
            return;
        }
        inorderDFSTraversal(root.left);
        nodeValuesinOrderDFS.add(Integer.parseInt(root.data.toString()));
        inorderDFSTraversal(root.right);
    }
}