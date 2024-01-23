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
    public int mincostTickets(int[] days, int[] cost) {
        //memoization
        //since only cday varying it can max go to 365 days
        //but since ticket can be purch
        Integer[] dp = new Integer[366];
        return helper(days[0], days, cost, dp);
    }
}