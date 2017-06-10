/**

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }   
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode cur = new ListNode(sum % 10);
            last.next = cur;
            last = cur;
        }
        
        if (carry == 1) {
            last.next = new ListNode(1);
        }
        
        return dummy.next;
        
    }
}

/**
	
	Watch out: If the carry bit is on, add a new node in the end.

**/