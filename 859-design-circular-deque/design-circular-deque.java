class MyCircularDeque {

    int cap;
    Node head;
    Node tail;
    int size;


    public MyCircularDeque(int cap) {
        this.cap = cap;
        size = 0;
        head = tail = null;    
    }
    
    public boolean insertFront(int value) {

        if(size == cap){
            return false;
        }

        Node node = new Node(value);
        if(size == 0){
            node.next = node;
            node.prev = node;
            head = node;
            tail = node;
            
        }else{
            node.next = head;
            node.prev = tail;
            head.prev = node;
            head = node;
            tail.next = head;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {

        if(size == cap){
            return false;
        }

        Node node = new Node(value);
        if(size == 0){
            node.next = node;
            node.prev = node;
            head = node;
            tail = node;
            
        }else{
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node; 
            tail = node;
            tail.next = head;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(size == 1) {
            head = tail = null;
            size--;
            return true;
        }
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return true;
        
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;

        if(isEmpty()) return false;
        if(size == 1) {
            head = tail = null;
            size--;
            return true;
        }
        tail = tail.prev;
        head.prev = tail;
        tail.next = head;
        size--;
        return true;
        
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return head.val;
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==cap;
    }
}

class Node{
    int val;
    Node next;
    Node prev;

    Node(int val){
        this.val = val;
        prev = next = null;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */