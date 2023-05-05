class MapSum {
    class Node{
        Node[] childs;
        int score;
        
        Node(){
            childs = new Node[26];
            score = 0;
        }
    }
    
    Node root;
    HashMap<String, Integer> hm;
    
    public MapSum() {
        root = new Node();
        hm = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delta = val - hm.getOrDefault(key, 0);
        
        Node curr = root;
        
        for(char ch : key.toCharArray()){
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }
            
            curr.childs[ch - 'a'].score += delta;
            curr = curr.childs[ch - 'a'];
        }
        
        hm.put(key, val);
    }
    
    public int sum(String prefix) {
        Node curr = root;
        
        for(char ch : prefix.toCharArray()){
            if(curr.childs[ch - 'a'] == null){
                return 0;
            }
            curr = curr.childs[ch - 'a'];
        }
        
        return curr.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */