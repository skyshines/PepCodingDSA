class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 1){
            List<Integer> bres = new ArrayList<>();
            bres.add(0);
            bres.add(1);
            return bres;
        }
        
        List<Integer> rres = grayCode(n - 1);
        List<Integer> myres = new ArrayList<>();
        
        for(int val : rres) myres.add(val);
        
        for(int i = rres.size() - 1; i >= 0; i--){
            myres.add(rres.get(i) + (1 << n - 1));
        }
        
        return myres;
        
    }
}