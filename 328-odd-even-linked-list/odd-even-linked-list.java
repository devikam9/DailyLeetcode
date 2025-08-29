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
    public ListNode oddEvenList(ListNode head) {

        if(head == null) return null;
        ListNode oddHead = head;
        ListNode evenHead = head.next;;

        ListNode odd = oddHead;
        ListNode even = evenHead;

        while(odd != null && odd.next != null && even.next != null){

            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }


        odd.next = evenHead;

        return oddHead;
    }
}