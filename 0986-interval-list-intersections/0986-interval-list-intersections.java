class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<Integer[]> arr = new ArrayList<>();
        
        int i = 0; int j = 0;
        
        while(i < firstList.length && j < secondList.length){
            int csp = Math.max(firstList[i][0],secondList[j][0]);
            int cep = Math.min(firstList[i][1],secondList[j][1]);
            if(cep >= csp){
                Integer[] ans = {csp,cep};
                arr.add(ans);
                
            }
                if(firstList[i][1] > secondList[j][1]){
                    j++;
                }else{
                    i++;
                }
        }
        
        int[][] ans = new int[arr.size()][2];
        
        for(int k = 0; k < ans.length; k++){
            for(int l = 0; l < 2; l++){
                ans[k][l] = arr.get(k)[l];
            }
        }
        
        return ans;
    }
}