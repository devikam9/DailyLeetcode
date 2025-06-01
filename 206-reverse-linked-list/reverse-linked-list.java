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
    public ListNode reverseList(ListNode head) {
        // -1 -2 3 - 4 - 5
        //         p   c  n 
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = curr;

        while(curr != null){

            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } 
        return prev;     
    }
}