class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        
        for(int f = 1; f <= n; f++){
            dp[1][f] = f;
        }
        
        for(int e = 1; e <= k; e++){
            dp[e][1] = 1;
        }
        
        for(int eggs = 2; eggs <= k; eggs++){
            for(int floors = 2; floors <= n; floors++){
               
                    int min = Integer.MAX_VALUE;
                    int h = floors;
                    int l = 1;
                    
                    while(l <= h){
                        int mid = l + (h - l) / 2;
                        
                        int left = dp[eggs - 1][mid - 1];
                        int right = dp[eggs][floors - mid];
                        int max = Math.max(left, right);
                        
                        if(left<right){                  
                            l=mid+1;                       
                        }
                        else                             
                        {    
                            h=mid-1;
                        }
                        
                        min=Math.min(min,max);
                    }
                    
                    dp[eggs][floors] = min + 1;
                
            }
        }
        
        return dp[k][n];
    }
}