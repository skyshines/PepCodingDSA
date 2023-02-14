class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        
        TreeSet<Integer> dryPlace = new TreeSet<>();
        
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                dryPlace.add(i);
                ans[i] = 1;
            }else{
                ans[i] = -1;
                Integer isFill = lastRain.get(rains[i]);
                
                if(isFill == null){
                    lastRain.put(rains[i],i);
                }else{
                    Integer isDryAva = dryPlace.higher(isFill);
                    
                    if(isDryAva == null){
                        return new int[0];
                    }else{
                        ans[isDryAva] = rains[i];
                        
                        lastRain.put(rains[i],i);
                        
                        dryPlace.remove(isDryAva);
                    }
                }
            }
        }
        
        return ans;
    }
}