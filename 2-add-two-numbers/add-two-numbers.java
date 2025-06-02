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
        int carry = 0, sum = 0;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }

            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l2 != null){
            sum = carry + l2.val;
             if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l2 = l2.next;
                
        }

        while(l1 != null){
            sum = carry + l1.val;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = l1.next;
        }

        if(carry > 0) dummy.next = new ListNode(carry);
        
        return temp.next;
    }
}