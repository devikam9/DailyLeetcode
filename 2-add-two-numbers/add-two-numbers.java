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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null ||  l2 != null){
            int x = l2 != null ? l2.val  : 0;
            int y = l1 != null ? l1.val : 0;

            int sum = x + y + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }

            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) dummy.next = new ListNode(carry);
        
        return temp.next;
    }
}