class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('c',0);
        hm.put('r',0);
        hm.put('o',0);
        hm.put('a',0);
        hm.put('k',0);
        
        //removing invalid testcases
        for(char ch : croakOfFrogs.toCharArray()){
            hm.put(ch,hm.get(ch) + 1);
            
            if(hm.get('c') < hm.get('r') || hm.get('c') < hm.get('o') || hm.get('c') < hm.get('a') || hm.get('c') < hm.get('k')){
                return -1;
            }
            
            if(hm.get('r') < hm.get('o') || hm.get('r') < hm.get('a') || hm.get('r') < hm.get('k')){
                return -1;
            }
            
            if(hm.get('o') < hm.get('a') || hm.get('o') < hm.get('k')){
                return -1;
            }
            
            if(hm.get('a') < hm.get('k')){
                return -1;
            }
        }
        int a = hm.get('c');
        
        if((a == hm.get('r') && a == hm.get('o') && a == hm.get('a') && a == hm.get('k')) == false) return -1;
        
        //platforms problem GFG
        int frogs = 0;
        int ans = 0;
        
        for(char ch : croakOfFrogs.toCharArray()){
            if(ch == 'c'){
                frogs++;
            }else if(ch == 'k'){
                frogs--;
            }
            
            ans = (int)Math.max(frogs,ans);
        }
        
        return ans;
    }
}