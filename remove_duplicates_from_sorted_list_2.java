
//Remove Duplicates from Sorted List II

// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null) { // we still have two node left
            //we find a duplicate
            if (cur.next.val == cur.next.next.val) {
                int dupVal = cur.next.val;
                //go to next node untill find node with node.val != dupVal
                while (cur.next != null && cur.next.val == dupVal) {
                    //skip the next node 
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}