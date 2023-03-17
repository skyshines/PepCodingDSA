class Solution {
    public boolean helper(int[] matchsticks,int maxSide, long[] sides, int idx){
        if(idx == -1){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        
        for(int i = 0; i < 4; i++){
            
            //1st optmization -> dont overflow side beyond limit
            if(sides[i] + matchsticks[idx] > maxSide){
                continue;
            }
            
            int j = i - 1;
            
            while(j >= 0 && sides[i] != sides[j]){
                j--;
            }
            
            if(j != -1) continue;
            
            
            sides[i] += matchsticks[idx];
            
            if(helper(matchsticks, maxSide, sides, idx - 1) == true){
                return true;
            }
            
            sides[i] -= matchsticks[idx];
        }
        
        return false;
    }
    
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) return false;
        
        long[] sides = new long[4];
        
        int sum = 0;
        for(int val : matchsticks) sum += val;
        int maxSide = sum / 4;
        
        //2nd optimization start from correct index
        int idx = matchsticks.length - 1;
        Arrays.sort(matchsticks);
        
        while(idx >= 0 && matchsticks[idx] > maxSide){
            idx--;
        }
        
        if(idx < 3) return false;
        
        return helper(matchsticks, maxSide, sides, idx);
    }
}