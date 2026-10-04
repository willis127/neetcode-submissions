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
    private boolean checkExit(ListNode[] nodes) {
        int nullCnt = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null)
                nullCnt++;
        }
        if (nullCnt == nodes.length)
            return true;
        else
            return false;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode[] pArr = new ListNode[lists.length];
        for (int i = 0 ; i < lists.length; i++) {
            pArr[i] = lists[i];
        }
        ListNode head = null, p = null;
        int minStart = 0;
        while (pArr[minStart] == null && minStart < lists.length - 1)
                minStart++;
        int minIdx = 0;
        while (true) {
            minIdx = minStart;
            if (checkExit(pArr))
                return head;
            for (int i = minIdx + 1 ; i < lists.length; i++) {
                if (pArr[i] == null)
                    continue;
                if (pArr[minIdx].val > pArr[i].val) {
                    minIdx = i;
                }
            }
            if (head == null) {
                head = pArr[minIdx];
                p = head;
            } else {
                p.next = pArr[minIdx];
                p = p.next;
            }
            pArr[minIdx] = pArr[minIdx].next;
            if (minIdx == minStart) {
                minStart = minIdx;
                while (pArr[minStart] == null && minStart < lists.length - 1)
                    minStart++;
            }
        }
    }
}
