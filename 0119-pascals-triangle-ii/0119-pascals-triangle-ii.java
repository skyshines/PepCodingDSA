class Solution {
    public List<Integer> getRow(int rowIndex) {
        Long val = 1L;
        List<Integer> ans = new ArrayList<>();
        
        for(int i = rowIndex,j = 0; j <= rowIndex; j++){
            ans.add(val.intValue());
            val = (val * (i - j)) / (j + 1);
        }
        
        return ans;
        
    }
}