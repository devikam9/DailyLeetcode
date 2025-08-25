/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 1st move and then u compare
        // At any point if slow == fast -> then cycle is found
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            
            fast = fast.next;
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}