class CustomStack {
    int value[];
    int increment[];
    int index;
    
    public CustomStack(int maxSize) {
        value = new int[maxSize];
        increment = new int[maxSize];
        index = -1;
    }
    
    public void push(int x) {
        if(index + 1 == value.length){
            return;
        }
        
        index++;
        value[index] = x;
        increment[index] = 0;
    }
    
    public int pop() {
        if(index == -1){
            return -1;
        }
        
        int val = value[index];
        int inc = increment[index];
        index--;
        
        if(index >= 0){
            increment[index] += inc;
        }
        
        return val + inc;
    }
    
    public void increment(int k, int val) {
        int idx = (int)Math.min(k - 1, index);
        if(idx >= 0) increment[idx] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */