class Solution {
    List<String> ans;
    
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        
        helper(s, 0, 0,"");
        
        return ans;
    }
    
    public void helper(String s, int index, int noOfPartitionsSoFar,String asf){
        if(index == s.length()){
            if(noOfPartitionsSoFar == 4) ans.add(asf);
            return;
        }
        
        if(asf.length() != 0){
            asf = asf + ".";
        }
        
        if(noOfPartitionsSoFar < 4){
            helper(s, index + 1, noOfPartitionsSoFar + 1, asf + s.substring(index, index + 1));
        }
        
        if(noOfPartitionsSoFar < 4 && (index + 2 <= s.length()) && s.charAt(index) != '0'){
            helper(s, index + 2, noOfPartitionsSoFar + 1, asf + s.substring(index, index + 2));
        }
        
        if(noOfPartitionsSoFar < 4 && (index + 3 <= s.length()) && s.charAt(index) != '0'){
            String add = s.substring(index, index + 3);
            
            if(Integer.parseInt(add) <= 255){
                helper(s, index + 3, noOfPartitionsSoFar + 1, asf + add);
            }    
        }
        
    }
}