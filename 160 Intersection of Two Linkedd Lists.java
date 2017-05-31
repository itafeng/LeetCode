/**

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        int cnt1 = 0;
        while (a != null) {
            ++cnt1;
            a = a.next;
        }
        
        int cnt2 = 0;
        while (b != null) {
            ++cnt2;
            b = b.next;
        }
        
        a = headA;
        b = headB;
        if (cnt1 > cnt2) {
            for (int i = 0; i < cnt1 - cnt2; ++i) {
                a = a.next;
            }
        }
        else {
            for (int i = 0; i < cnt2 - cnt1; ++i) {
                b = b.next;
            }
        }
        
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
}

/**
	Note:
	
	

**/