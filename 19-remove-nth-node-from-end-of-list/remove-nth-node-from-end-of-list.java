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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //for loop k = size - n 
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }
        int k = size - n;
        ListNode temp1 = head;
        ListNode prev = null;
        for(int i = 1; i < k && temp1 != null; i++){
            prev = temp1;
            temp1 = temp1.next;   
        }
        temp1.next = temp1.next.next;

        return head;
    }
}