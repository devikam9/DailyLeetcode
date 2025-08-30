/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //1. find lengths of both the linkedlists
        //2. use a helper function to determine if they are equal or not and return

        ListNode tempA = headA;
        ListNode tempB = headB;

        int length1 = 0;
        int length2 = 0;
        while(tempA != null){
            length1++;
            tempA = tempA.next;
        }

        while(tempB != null){
            length2++;
            tempB = tempB.next;
        }

        if(length2 > length1){
            //smaller, larger, difference
            return collisionPoint(headA, headB, length2 - length1);
        }else{
            //smaller, larger, difference
            return collisionPoint(headB, headA, length1 - length2);
        }
    }

    public ListNode collisionPoint(ListNode temp1, ListNode temp2, int distance){

        while(distance > 0){
            distance --;
            temp2 = temp2.next;
        }

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}