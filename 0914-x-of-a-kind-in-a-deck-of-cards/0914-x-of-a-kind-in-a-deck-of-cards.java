class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val : deck){
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        
        int ans = 0;
        
        for(int val : hm.values()){
            ans = gcd(ans, val);
        }
        
        return ans > 1;
    }
    
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b, a % b);
    }
}