class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        
        Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Pair other){
            return this.freq - other.freq;
        }
    }
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder("");
        HashMap<Character,Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c, 0) + 1);
        }
        
        for(char c : hm.keySet()){
            pq.add(new Pair(c,hm.get(c)));
        }
        
        while(pq.size() > 0){
            Pair p = pq.poll();
            for(int i = 0; i < p.freq; i++){
                sb.append(p.ch);
            }
        }
        
        return sb.toString();
    }
}