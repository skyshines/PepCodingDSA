class Solution {
    public int maxProfit(int[] prices) {
        int mpist = 0; //max profit if sold today
        int lsf = prices[0]; //least so far
        
        int[] dpmpisut = new int[prices.length]; //dp of max profit if sold upto today
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            
            mpist = prices[i] - lsf;
            
            dpmpisut[i] = Math.max(dpmpisut[i - 1], mpist);
        }
        
        
        int[] dpmpibat = new int[prices.length]; // dp of max profit if bought after today
        int msf = prices[prices.length - 1]; //max so far
        int mpibt = 0; // max profit if bought today
        
        for(int i = prices.length - 2; i >= 0; i--){
            if(prices[i] > msf){
                msf = prices[i];
            }
            
            mpibt = msf - prices[i];
            
            dpmpibat[i] = Math.max(dpmpibat[i + 1], mpibt);
        }
        
        int ans = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(dpmpibat[i] + dpmpisut[i] > ans){
                ans = dpmpibat[i] + dpmpisut[i];
            }
        }
        
        return ans;
    }
}