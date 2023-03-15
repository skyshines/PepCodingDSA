class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String domain : cpdomains){
            String[] temp = domain.split(" ");
            int visitCount = Integer.parseInt(temp[0]);
            
            String[] words = temp[1].split("\\.");
            StringBuilder subdomain = new StringBuilder("");
            
            for(int i = words.length - 1; i >= 0; i--){
                if(i == words.length - 1){
                    subdomain.append(words[i]);
                }else{
                    subdomain.insert(0,words[i] + ".");
                }
                
                hm.put(subdomain.toString(),hm.getOrDefault(subdomain.toString(), 0) + visitCount);
            }
        }
        
        for(String str : hm.keySet()){
            StringBuilder sb = new StringBuilder("");
            sb.append(hm.get(str));
            sb.append(" ");
            sb.append(str);
            ans.add(sb.toString());
        }
        
        return ans;
    }
}