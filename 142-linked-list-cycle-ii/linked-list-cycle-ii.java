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
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode fast = head;
        int index = 0;
        while(fast != null){
            if(!map.containsKey(fast)){
               map.put(fast,index); 
               index++;
            }else{
                return fast;
            }
            fast = fast.next;    
        }
        return null;    
    }
}