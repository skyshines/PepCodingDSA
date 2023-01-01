class StockSpanner {
    class Pair{
        int price;
        int index;
        
        Pair(int price, int index){
            this.price = price;
            this.index = index;
        }
    }
    
    static Stack<Pair> st;
    static int count;
    
    public StockSpanner() {
        st = new Stack<>();
        count = 0;
        int max = 1000000; // max price can go is 10^5 so we just pushed one number bigger than that
        //pushing max with index 0 and incrementing count;
        st.push(new Pair(max,0));
    }
    
    public int next(int price) {
        
        while(st.peek().price <= price){
            st.pop();
        }
        
        
        count++;
        int ans = count - st.peek().index;
        
        st.push(new Pair(price,count));
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */