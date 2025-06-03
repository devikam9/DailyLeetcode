/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //1. Insert in between nodes and increment temp = temp.next.next;

        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        temp = head;
        //2. Now insert the random pointers
        while(temp != null){
            Node node = temp.next;
            if(temp.random != null)
                node.random = temp.random.next;
            else
                node.random = null;
            temp = temp.next.next;
        }

        //3. insert the next nodes and return - so create a dummy node.
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
            
        }
    
        return dummy.next;
    }
}