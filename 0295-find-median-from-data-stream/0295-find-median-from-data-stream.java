class MedianFinder {
    PriorityQueue< Integer> left;
    PriorityQueue< Integer> right;
    
    public void handleBalance(){
        if(left.size() - right.size() == 2){
            right.add(left.remove());
        }else if(right.size() - left.size() == 2){
            left.add(right.remove());
        }
    }

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int val) {
        
        
        if(right.size() > 0 && val > right.peek()) {
            right.add(val);
        }else {
            left.add(val);
        }
        
        handleBalance();
    }
    
    public double findMedian() {
        
        if((left.size() + right.size()) % 2 == 0){
            return (left.peek()*1.0 + right.peek())/2;
        }else{
            if(left.size() > right.size()){
                return left.peek();
            }else{
                return right.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */