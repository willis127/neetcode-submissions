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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = null, p2 = null;
        ListNode head = null, p = null;
        while(list1 != null || list2 != null) {
            if ((list1 != null && list2 != null && list1.val < list2.val) || (list1 != null && list2 == null)) {
                p1 = list1;
                list1 = list1.next;
                p1.next = null;
            } else {
                p1 = list2;
                list2 = list2.next;
                p1.next = null;
            }
            if (p == null) {
                p = p1;
            } else {
                p.next = p1;
                p = p.next;
            }
            if (head == null)
                head = p;
        }
        return head;
    }
}
