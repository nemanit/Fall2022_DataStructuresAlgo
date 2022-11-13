package Question4.src;

public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    // time complexity: O(n) in the worst case, I need to traverse all nodes in linked list
    // space complexity: O(1) no need of extra space
    public void insert(Integer data){

        // asked TA and TA explained me the question that a sorted linked list will be given and I need to insert
        // the value into an already sorted list.
        Node toBeInsertedNode = new Node(data);

        if (head == null) {
            head = toBeInsertedNode;
            return;
        }

        if (head.data >= data ) {
            toBeInsertedNode.next = head;
            head = toBeInsertedNode;
            return;
        }

        Node currentNode = head;

        while(currentNode.next != null && currentNode.next.data < toBeInsertedNode.data) {
            currentNode = currentNode.next;
        }

        toBeInsertedNode.next = currentNode.next;
        currentNode.next = toBeInsertedNode;
    }
}