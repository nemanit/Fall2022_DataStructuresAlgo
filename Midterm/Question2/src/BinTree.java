package Question2.src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinTree<T> {
    public Node<T> root;

    public BinTree() {

    }

    // Time complexity: o(n) traverse all nodes only twice
    // Space complexity: o(n) hasmap of n nodes
    public void populateParent(Node root) {
        if(root == null) {
            return;
        }
        HashMap<Integer, Integer> hashMapParent = new HashMap<Integer, Integer>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    hashMapParent.put(Integer.parseInt(currentNode.left.data.toString()), Integer.parseInt(currentNode.data.toString()));
                }
                if (currentNode.right != null) {
                    hashMapParent.put(Integer.parseInt(currentNode.right.data.toString()), Integer.parseInt(currentNode.data.toString()));
                }
            }
        }

        queue.add(root.right);
        queue.add(root.left);
        root.parent = null;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node currentNode = queue.poll();



                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    currentNode.parent = hashMapParent.get(Integer.parseInt(currentNode.data.toString()));
                }
                if (currentNode.right != null) {
                    currentNode.parent = hashMapParent.get(Integer.parseInt(currentNode.data.toString()));                }
            }
        }
    }
}