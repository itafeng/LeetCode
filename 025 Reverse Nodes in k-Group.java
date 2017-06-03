/**

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


**/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        int i = k;
        
        while (i > 0 && tmp != null) {
            tmp = tmp.next;
            --i;
        }
        
        if (i > 0) {
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        
        while (cur != tmp) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        head.next = reverseKGroup(tmp, k);
        return prev;
    }
}

/**
	Note:
	
	

**/