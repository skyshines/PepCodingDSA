class Solution {
    public class Node{
        Node[] childs;
        String str;
        
        Node(){
            childs = new Node[26];
            str = null;
        }
    }
    
    public void insertInTrie(Node root, String word){
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            Node child = curr.childs[ch - 'a'];
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }else{
                
                if(curr.childs[ch - 'a'].str != null){
                    return;
                }
            }
            
            curr = curr.childs[ch - 'a'];
        }
        
        curr.str = word;
    }
    
    public String searchPrefix(Node root, String word){
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            Node child = curr.childs[ch - 'a'];
            
            if(child == null){
                return null;
            }else{
                if(child.str != null){
                   return child.str; 
                }
            }
            
            curr = child;
        }
        
        return null;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
         Node root = new Node();
        
        for(String str : dictionary){
            insertInTrie(root, str);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(String word : words){
            String prefix = searchPrefix(root, word);
            
            if(sb.length() != 0){
                sb.append(" ");
            }
            
            if(prefix != null){
                sb.append(prefix);
            }else{
                sb.append(word);
            }
        }
            
        return sb.toString();    
    }
} 