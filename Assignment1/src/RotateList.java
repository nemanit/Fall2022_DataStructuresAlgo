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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        if(k == 0) {
            return head;
        }
        ListNode headStart = head;
        int length = 1;
        while(head.next != null) {
            length++;
            head = head.next;
        }
        if (length == 1) {
            return headStart;
        }
        if (length == k || k % length == 0) {
            return headStart;
        }
        if (k> length) {
            k = k % length;
        }
        int i = 1;
        head = headStart;
        while (i < length-k) {
            head = head.next;
            i++;
        }
        ListNode tempHead = head.next;
        head.next = null;
        ListNode newHead = tempHead;
        while(tempHead.next!=null){
            tempHead = tempHead.next;
        }
        tempHead.next = headStart;
        return newHead;
    }
}