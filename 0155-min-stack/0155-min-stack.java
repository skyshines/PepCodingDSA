class MinStack {
    Stack<Long> data;
    Long min;
    
    public MinStack() {
        data = new Stack<>();
    }
    
    public void push(int val) {
        if(data.size() == 0){
            min = (long)val;
            data.push(min);
        }else if((long)val >= min){
            data.push((long)val);
        }else{
            data.push(2*(long)val - min);
            min = (long)val;
        }
    }
    
    public void pop() {
        if(data.peek() >= min){
            data.pop();
        }else{
            long oval = 2*min - data.pop();
            min = oval;
        }
    }
    
    public int top() {
        if(data.peek() >= min){
            return data.peek().intValue();
        }else{
            return min.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/*
using linear space

/*
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
