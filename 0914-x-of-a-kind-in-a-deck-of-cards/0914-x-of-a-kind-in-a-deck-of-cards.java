class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val : deck){
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        
        int gcd = 0;
        
        for(int val : hm.values()){
            gcd = gcd(gcd, val);
        }
        
        return gcd > 1;
    }
    
    public int gcd(int a, int b){
        if(a * b == 0){
            return a == 0 ? b : a;
        }
        
        while(b % a > 0){
            int t = a;
            a = b % a;
            b = t;
        }
        
        return a;
    }
}