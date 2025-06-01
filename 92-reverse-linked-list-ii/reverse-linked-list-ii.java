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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //1. fast and slow pointers - stop when they reach to the right
        //2. do reverse a LL
        if(head == null || head.next == null) return head; 

        ListNode prev = null;
        ListNode curr = head;


        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        ListNode tail = curr, con = prev, third = null;

        while(right > 0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            right--;
        }

        if(con != null)
            con.next = prev;
        else
            head = prev;

        tail.next = curr;

        return head;
        
          
    }
}