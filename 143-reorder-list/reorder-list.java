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
        //1. use fast and slow to find the mid
        //2. from mid to end reverse the list
        //3. insert alternaively head to mid, reversed list and return.

        //1.
        ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //2.
        ListNode curr = slow;
        ListNode next = slow;
        ListNode prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //3.
        ListNode temp1 = head;
        ListNode temp2 = prev;

        while(temp2.next != null){
            ListNode first = temp1.next;
            ListNode second = temp2.next;

            temp1.next = temp2;
            temp2.next = first;
            
            temp1 = first;
            temp2 = second;
        }
    }
}