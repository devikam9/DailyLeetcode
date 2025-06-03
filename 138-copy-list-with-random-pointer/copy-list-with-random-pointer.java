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

        Map<Node,Node> copy = new HashMap<>();
        Node temp = head;

        while(temp != null){
            copy.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node next = temp.next;
            Node rand = temp.random;
            Node node = copy.get(temp);
            node.next = copy.get(next);
            if(rand != null){
                node.random = copy.get(rand);
            }else{
                node.random = null;
            }
            temp = temp.next;
            
        }
        return copy.get(head);    
    }
}