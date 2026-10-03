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
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode[] arr = new ListNode[length];
        p = head;
        int i = 0;
        while (p != null) {
            arr[i] = p;
            i++;
            p = p.next;
        }
        i = 0;
        while (i <= length - 1 - i) {
            arr[i].next = arr[length - 1 - i];
            arr[length - 1 - i].next = null;
            if (i > 0) {
                arr[length - i].next = arr[i];
            }
            i++;
        }
        head = arr[0];
        return;
    }
}
