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

        Map<Node,Node> map = new HashMap<>();
        Node temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            temp = temp.next;
        }

        Node temp1 = head;
        while(temp1 != null){
            Node newNode = map.get(temp1);
            newNode.next = map.get(temp1.next);
            newNode.random = map.get(temp1.random);
            temp1 = temp1.next;
        }
        
        return map.get(head);
    }
}