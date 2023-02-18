class MinStack {
    Stack<Integer> data;
    Stack<Integer> mindata;
    public MinStack() {
        data = new Stack<>();
        mindata = new Stack<>();
    }
    
    public void push(int val) {
        data.push(val);
        if(mindata.size() == 0 || mindata.peek() >= val) mindata.push(val);
    }
    
    public void pop() {
        int val = data.pop();
        
        if(mindata.peek() == val) mindata.pop();
        
        
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return mindata.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */