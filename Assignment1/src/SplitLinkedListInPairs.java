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
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] finalNodeList = new ListNode[k];
        if (head == null){
            return finalNodeList;
        }
        ListNode headStart = head;
        int length = 1;
        while(head.next != null) {
            length++;
            head = head.next;
        }
        head = headStart;
        int numberOfItemsExtraCounter = length % k;
        int iterationCounter = 0;
        int realCounter = k;
        if ((length/k) == 0) {
            realCounter = length;
        }
        while (iterationCounter < realCounter) {
            int lengthOfSplit = 0;
            if (iterationCounter < numberOfItemsExtraCounter) {
                lengthOfSplit = (length/k) + 1;
            } else {
                lengthOfSplit = length/k;
            }
            int internalCounter = 1;
            ListNode tempHead = head;
            while(internalCounter<lengthOfSplit) {
                head = head.next;
                internalCounter++;
            }
            ListNode nextHead = head.next;
            head.next = null;
            finalNodeList[iterationCounter] = tempHead;
            head = nextHead;
            iterationCounter++;
        }
        return finalNodeList;
    }
}