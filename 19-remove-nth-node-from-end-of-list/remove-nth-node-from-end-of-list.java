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

        //Bruteforce approach

        //iterate the list and get size
        //subtract n from size and iterate again till n -1 and remove n

        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(size == n){
            //remove the 0 index i.e; head - so you will return head.next
             return head.next;
        }
        int remPos = size - n;
        temp = head;
        while(temp != null){
            remPos--;
            if(remPos == 0){
                temp.next = temp.next.next;
                break;
            }
            
            temp = temp.next;
        }

        return head;
        
    }
}