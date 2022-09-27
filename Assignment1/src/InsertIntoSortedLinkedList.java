/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node headNode = head;
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        if (head.next == null) {
            head.next = insertNode;
            insertNode.next = head;
            return headNode;
        }
        Node previousHead = headNode;
        Node currentHead = headNode.next;
        while(currentHead.next!= null) {
            if (previousHead.val <= insertVal && insertVal <= currentHead.val) {
                previousHead.next = insertNode;
                insertNode.next = currentHead;
                return headNode;
            } else if (previousHead.val > currentHead.val && insertVal >= previousHead.val) {
                previousHead.next = insertNode;
                insertNode.next = currentHead;
                return headNode;
            } else if (previousHead.val > currentHead.val && insertVal <= currentHead.val) {
                previousHead.next = insertNode;
                insertNode.next = currentHead;
                return headNode;
            } else {
                previousHead = previousHead.next;
                currentHead = currentHead.next;
            }
            if (previousHead == headNode) {
                break;
            }
        }
        previousHead.next = insertNode;
        insertNode.next = currentHead;
        return headNode;
    }
}