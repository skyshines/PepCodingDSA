class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> arr = new ArrayList<>();
        
        int i = 0; int j = 0;
        
        while(i < firstList.length && j < secondList.length){
            int csp = Math.max(firstList[i][0],secondList[j][0]);
            int cep = Math.min(firstList[i][1],secondList[j][1]);
            if(cep >= csp){
                int[] ans = {csp,cep};
                arr.add(ans);
                
            }
                if(firstList[i][1] > secondList[j][1]){
                    j++;
                }else{
                    i++;
                }
        }
        
        return arr.toArray(new int[arr.size()][2]);
    }
}