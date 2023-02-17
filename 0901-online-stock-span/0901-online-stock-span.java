class StockSpanner {
    class Pair{
        int val;
        int idx;
        
        Pair(int v,int i){
            val = v; idx = i;
        }
    }
    
    static Stack<Pair> st;
    static int i;
    
    public StockSpanner() {
        st = new Stack<>();
        i = 0;
    }
    
    public int next(int price) {
        //pop
        while(st.size() > 0 && st.peek().val <= price) st.pop();
        
        int ans;
        
        if(st.size() == 0){
            ans = i + 1;
        }else{
            ans = i - st.peek().idx;
        }
        
        st.push(new Pair(price,i));
        
        i++;
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */