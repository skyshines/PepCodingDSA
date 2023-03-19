class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
            return this.freq - o.freq;
        }
    }
    public String reorganizeString(String s) {
        int[] freq_map = new int[26];
        
        for(char ch : s.toCharArray()){
            freq_map[ch - 'a']++;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < 26; i++){
            if(freq_map[i] == 0) continue;
            
            pq.add(new Pair((char)(i + 'a'), freq_map[i]));
        }
        
        if(pq.peek().freq > (s.length() + 1) / 2) return "";
        
        Pair Blocker = pq.remove();
        StringBuilder sb = new StringBuilder();
        sb.append(Blocker.ch);
        Blocker.freq--;
        
        Pair temp;
        
        while(pq.size() > 0){
            temp = pq.remove();
            
            sb.append(temp.ch);
            temp.freq--;
            
            if(Blocker.freq > 0){
                pq.add(Blocker);
            }
            
            Blocker = temp;
        }
        
        return sb.toString();
        
    }
}