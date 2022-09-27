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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode headStart = head;
        int length = 1;
        int firstElementValue = 0;
        int secondElementValue = 0;
        int firstElementPosition = k;
        while(head.next != null) {
            length++;
            head = head.next;
        }
        int secondElementPosition = length - k + 1;
        if (firstElementPosition == secondElementPosition) {
            return headStart;
        }
        head = headStart;
        int i = 1;
        while (head != null) {
            if (i == firstElementPosition) {
                firstElementValue = head.val;
            }
            else if (i == secondElementPosition) {
                secondElementValue = head.val;
            }
            head = head.next;
            i++;
        }
        head = headStart;
        i= 1;
        while(head != null) {
            if (i == firstElementPosition) {
                head.val = secondElementValue;
            }else if (i == secondElementPosition) {
                head.val = firstElementValue ;
            }
            head = head.next;
            i++;
        }
        return headStart;
    }
}