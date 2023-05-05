class Solution {
    public class Node{
        Node[] childs;
        String str;
        
        Node(){
            childs = new Node[26];
            str = null;
        }
    }
    
    public void insert(Node root, String word){
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }
            
            curr = curr.childs[ch - 'a'];
        }
        
        curr.str = word;
    }
    
    String ans;
    
    public void dfs(Node node){
        for(Node child : node.childs){
            if(child != null && child.str != null){
                if(child.str.length() > ans.length()){
                    ans = child.str;
                }
                
                dfs(child);
            }
        }
    }
    
    public String longestWord(String[] words) {
        Node root = new Node();
        
        for(String word : words){
            insert(root, word);
        }
        
        ans = "";
        dfs(root);
        
        return ans;
    }
}