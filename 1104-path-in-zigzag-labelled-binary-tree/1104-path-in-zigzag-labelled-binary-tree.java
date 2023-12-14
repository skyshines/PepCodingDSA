class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int ctval = 0; //current tottal value
        int llv = 1; // last level value or N
        int n = label;
        
        while(ctval < n)
        {
            ctval += llv;
            llv = 2 * llv;
        }
        
        llv = llv / 2;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(label);
        
        while(n > 1){
            int compliment = 3 * llv - n - 1;
            int parent = compliment / 2;
            
            n = parent;
            llv = llv / 2;
            
            ans.add(parent);
        }
        
        Collections.reverse(ans);
        return ans;
        
    }
}