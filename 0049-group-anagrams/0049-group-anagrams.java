class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();
        
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
        
        for(String str : strs){
            HashMap<Character, Integer> fmap = new HashMap<>();
            
            for(char ch : str.toCharArray()){
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }
            
            if(bmap.containsKey(fmap)){
                bmap.get(fmap).add(str);
            }else{
                ArrayList<String> ls = new ArrayList<>();
                ls.add(str);
                bmap.put(fmap, ls);
            }
        }
        
        for(ArrayList<String> val : bmap.values()){
            List<String> ls = val;
            ans.add(ls);
        }
        
        return ans;
    }
}