class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 0) return 0;
        
        int pbd = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < pbd){
                pbd = prices[i];
            }else{
                int todayProfit = prices[i] - pbd;
                if(todayProfit > maxProfit) maxProfit = todayProfit;
            }
        }
        
        return maxProfit;
    }
}