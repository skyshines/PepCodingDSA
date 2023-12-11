class Solution {
    public int maxProfit(int[] prices) {
        int ssp = 0;
        int bsp = -prices[0];
        int csp = 0;
        
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(bsp, csp - prices[i]);
            int nssp = Math.max(ssp, bsp + prices[i]);
            int ncsp = Math.max(csp, ssp);
            
            bsp = nbsp;
            csp = ncsp;
            ssp = nssp;
        }
        
        return ssp;
        
    }
}