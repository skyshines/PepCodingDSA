class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        
        int k = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < k; i++){
            int ele = nums.get(i).get(0);
            int[] tba = {ele, 0, i};//to be added
            pq.add(tba);
            
            if(ele > max) max = ele;
        }
        
        while(true){
            int[] rem = pq.remove();
            
            if(max - rem[0] + 1 < res[1] - res[0] + 1){
                res[0] = rem[0];
                res[1] = max;
            }
            
            if(rem[1] == nums.get(rem[2]).size() - 1){
                break;
            }else{
                int nextEle = nums.get(rem[2]).get(rem[1] + 1);
                if(nextEle > max) max = nextEle;
                rem[0] = nextEle;
                rem[1]++;
                
                pq.add(rem);
            }
        }
        
        return res;
    }
}