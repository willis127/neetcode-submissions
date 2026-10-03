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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        ListNode[] arr = new ListNode[size];
        p = head;
        for (int i = 0 ; i < size; i++){
            arr[i] = p;
            p = p.next; 
        }
        if (size == 1 && n == 1)
            return null;
        if (n == size) {
            return arr[1];
        } else {
            arr[size - n - 1].next = n ==1 ? null : arr[size - n + 1];
            return arr[0];
        }
    }
}
