class MyCircularDeque {
    class Node{
        int data;
        Node next,prev;
        
        Node(int data){
            this.data = data;
        }
        
        Node(){
            data = 0;
        }
    }
    
    Node front,rear;
    int size;
    int limit;

    public MyCircularDeque(int k) {
        front = new Node();
        rear = new Node();
        
        front.next = rear;
        rear.prev = front;
        
        limit = k;
    }
    
    public boolean insertFront(int value) {
        if(size < limit){
            Node node = new Node(value);
            node.next = front.next;
            node.prev = front;
            
            
            front.next = node;
            node.next.prev = node;
            
            size++;
            return true;
            
        }else{
            return false;
        }
    }
    
    public boolean insertLast(int value) {
        if(size < limit){
            Node node = new Node(value);
            node.next = rear;
            node.prev = rear.prev;
            
            
            rear.prev = node;
            node.prev.next = node;
            
            size++;
            return true;
            
        }else{
            return false;
        }
    }
    
    public boolean deleteFront() {
        if(size == 0){
            return false;
        }
        
        Node node = front.next;
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        size--;
        
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0){
            return false;
        }
        
        Node node = rear.prev;
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        size--;
        
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;
        
        return front.next.data;
    }
    
    public int getRear() {
        if(size == 0) return -1;
        
        return rear.prev.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == limit;
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