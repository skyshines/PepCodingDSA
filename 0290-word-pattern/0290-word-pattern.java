class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String,String> map = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        
        String[] str = s.split(" ");
        if(str.length != pattern.length()){
            return false;
        }
        
        map.put(pattern.substring(0,1),str[0]);
        hs.add(str[0]);
        
        for(int i = 1; i < str.length; i++){
            String key = pattern.substring(i,i+1);
            if(map.containsKey(key)){
                if(str[i].equals(map.get(key)) == false){
                    return false;
                }
            }else{
                if(hs.contains(str[i])){
                    return false;
                }else{
                    map.put(key,str[i]);
                    hs.add(str[i]);
                }
            }
            
        }
        
        return true;
        
    }
}