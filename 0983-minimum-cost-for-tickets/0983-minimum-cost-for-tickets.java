class Solution {
    public boolean willITravelToday(int cday,int[] days){
        for(int day : days){
            if(day == cday){
                return true;
            }
        }
        
        return false;
    }
    public int helper(int cday,int[] days,int[] costs,Integer[] dp){
        if(cday > days[days.length - 1]) return 0;
        
        if(dp[cday] != null) return dp[cday];
        
        int ans = (int)1e8;
        if(willITravelToday(cday, days)){
            ans = helper(cday + 1,days,costs,dp) + costs[0];
            
            ans = Math.min(ans, helper(cday + 7,days, costs, dp) + costs[1]);
            
            ans = Math.min(ans, helper(cday + 30,days,costs, dp) + costs[2]);
        }else{
            ans = helper(cday + 1,days,costs, dp);
        }
        
        dp[cday] = ans;
        
        return ans;
    }
    
    public int tabulation(int[] days,int[] costs){
        int[] dp = new int[400];
        
        for(int cday = 399; cday >= 0; cday--){
            if(cday > days[days.length - 1]){
                //base case wala continue hoga
                continue;
            }
        
            int ans = (int)1e8;
            
            //we dont need willITravelToday function as we used it to reduce useless calls\
            if(willITravelToday(cday, days)){
                ans = dp[cday + 1] + costs[0]; //helper(cday + 1,days,costs,dp) + costs[0];

                ans = Math.min(ans, dp[cday + 7] + costs[1]);//Math.min(ans, helper(cday + 7,days, costs, dp) + costs[1]);

                ans = Math.min(ans, dp[cday + 30] + costs[2]);//Math.min(ans, helper(cday + 30,days,costs, dp) + costs[2]);

                dp[cday] = ans;
            }else{
                dp[cday] = dp[cday + 1];
            }
       
        }
        
        return dp[days[0]];
    }
    public int mincostTickets(int[] days, int[] cost) {
        //memoization
        //since only cday varying it can max go to 365 days
        //but since ticket can be purch
        return tabulation(days, cost);
    }
}