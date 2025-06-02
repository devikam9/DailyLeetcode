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
    public ListNode reverseKGroup(ListNode head, int k) {

        //1. traverse and find kth node
        //2. reverse function to reverse till k
        //3. join prevNode to reversed node - change head to reverse startnode for 1st time.
        //4. if you dont find k then attach to prevNode and return
        //4. do it every time till you reach end of list
        //5. return Head

        ListNode temp = head, prevLast = null;
        while(temp != null){

           ListNode kNode =  getKthNode(temp,k);
           //didn't find nodes till k
           if(kNode == null){
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
           }
           ListNode next = kNode.next;
           kNode.next = null;
           reverseList(temp);
           if(temp == head)
            head = kNode;
            else{
               prevLast.next = kNode; 
            }
           prevLast = temp;
           temp = next;

        }
        return head;
    }

    private ListNode getKthNode(ListNode temp, int k){
        k -= 1;//2
        while(temp != null && k > 0){
            k--;//1
            temp = temp.next;
        }
        return temp;
    }

    private ListNode reverseList(ListNode temp){

        ListNode prev = null;
        ListNode curr = temp;
        ListNode next = curr;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }    
}