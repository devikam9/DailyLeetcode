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
        //1. fast and slow pointers then you stop at slow when fast reaches null;
        //2. slow . next = prev, you reverse linkedlist after slow.next to end.
        //3. iterate from head and prev insert alternatively.

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = curr;

        //reverse the LinkedList from prev to null.

        while(curr != null){
            next = curr.next;
            curr.next = prev;;
            prev = curr;
            curr = next;
        }

        
        ListNode second = prev;
        ListNode first = head;
        while(second.next != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
            
        }       
        
    }
}