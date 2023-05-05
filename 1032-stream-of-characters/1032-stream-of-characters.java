class StreamChecker {
    public class Node{
        Node[] childs;
        boolean isEnd;
        
        Node(){
            childs = new Node[26];
            isEnd = false;
        }
    }
    
    Node root;
    StringBuilder sb;
    
    public StreamChecker(String[] words) {
        root = new Node();
        sb = new StringBuilder();
        
        for(String word : words){
            insert(word);
        }
    }
    
    public void insert(String word){
        Node curr = root;
        
        for(int i = word.length() - 1;  i >= 0; i--){
            char ch = word.charAt(i);
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }
            
            curr = curr.childs[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    
    public boolean query(char letter) {
        sb.append(letter);
        Node curr = root;
        
        for(int i = sb.length() - 1; i >= 0; i--){
            char ch = sb.charAt(i);
            
            if(curr.childs[ch - 'a'] == null){
                return false; 
            }else{
                if(curr.childs[ch - 'a'].isEnd == true){
                    return true;
                }
                
                curr = curr.childs[ch - 'a'];
            }
        }
        
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */