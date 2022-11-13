package Question1.src;

import java.util.LinkedList;
import java.util.Queue;

public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    //    space complexity is O(n) maximum elements we put in queue is n => number of nodes in tree
    // time complexity is O(n) we traverse each element only once
    public void populateNextLeft(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node previousNode = null;
            for (int i = queue.size(); i > 0; i--) {
                Node currentNode = queue.poll();

                currentNode.nextLeft = previousNode;

                System.out.println("The current node is " + currentNode.data.toString());
                if (previousNode == null ) {
                    System.out.println("The node attached as left node is null");
                } else {
                    System.out.println("The node attached as left node is " + previousNode.data.toString());
                }


                previousNode = currentNode;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.left);
                }
            }
        }
//        return root; commenting this as professor gave the signature as void return. so added print statements
    }
}