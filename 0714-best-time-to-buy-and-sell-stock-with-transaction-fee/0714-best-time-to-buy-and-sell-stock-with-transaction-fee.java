class Solution {
    public int maxProfit(int[] prices, int fee) {
        int ssp = 0; //sold state profit
        int bsp = -prices[0]; //bold state profit;
        
        for(int i = 1; i < prices.length; i++){
            int nssp = Math.max(ssp, bsp + prices[i] - fee);
            int nbsp = Math.max(bsp, ssp - prices[i]);
            
            bsp = nbsp;
            ssp = nssp;
        }
        
        return ssp;
    }
}