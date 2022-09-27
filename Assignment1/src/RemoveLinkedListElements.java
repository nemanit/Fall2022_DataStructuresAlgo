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
    public ListNode removeElements(ListNode head, int val) {
        ListNode headstart = head;
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
            headstart = head;
        }
        while(head != null && head.next != null) {
            if (head.next.val == val) {

                if (head.next.next == null) {
                    head.next = null;
                } else {
                    head.next = head.next.next;
                }
            }
            while(head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return headstart;
    }
}