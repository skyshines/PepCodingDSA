class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        
        for(int ans : answers){
            if(hm.containsKey(ans)){
                if(hm.get(ans) == ans + 1){
                    count += ans + 1;
                    hm.put(ans, 1);
                }else{
                    hm.put(ans, hm.get(ans) + 1);
                }
            }else{
                hm.put(ans, 1);
                count += ans + 1;
            }
        }
        
        return count;
    }
}