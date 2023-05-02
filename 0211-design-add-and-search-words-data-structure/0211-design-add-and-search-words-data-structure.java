class WordDictionary {
    public class Node{
        Node[] childs;
        boolean isEnd;
        
        Node(){
            childs = new Node[26];
            isEnd = false;
        }
    }
    
    private final Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }
            
            curr = curr.childs[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return find(root, word, 0);
    }
    
    private boolean find(Node curr, String word, int i){
        if(i ==  word.length()){
            return curr.isEnd;
        }
        
        if(word.charAt(i) == '.'){
            for(Node child : curr.childs){
                if(child == null) continue;
                
                boolean recursionResult = find(child, word, i + 1);
                
                if(recursionResult == true){
                    return true;
                }
            }
            
            return false;
            
        }else{
            if(curr.childs[word.charAt(i) - 'a'] == null){
                return false;
            }else{
                return find(curr.childs[word.charAt(i) - 'a'], word , i + 1);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */ 