class MyQueue {
    Stack<Integer> mainS;
    Stack<Integer> helperS;
    
    public MyQueue() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }
    
    public void push(int x) {
        while(mainS.size() > 0) helperS.push(mainS.pop());
        
        mainS.push(x);
        
        while(helperS.size() > 0) mainS.push(helperS.pop());
    }
    
    public int pop() {
        return mainS.pop();
    }
    
    public int peek() {
        return mainS.peek();
    }
    
    public boolean empty() {
        return mainS.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */