class Solution {
    public class Node{
        Node[] childs;
        String str;

        Node(){
            childs = new Node[26];
            str = null;
        }
        
        
    }
    public void makeTrie(Node root, String word){
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }
            
            curr = curr.childs[ch - 'a'];
        }
        
        curr.str = word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        
        Node root = new Node();
        for(String word : words){
            makeTrie(root, word);
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root,ans, visited);
            }
        }
        
        return ans;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public void dfs(char[][] board, int i, int j,Node curr,List<String> ans, boolean[][] visited){
        if(curr.childs[board[i][j] - 'a'] == null){
            return;
        }else{
            Node child = curr.childs[board[i][j] - 'a'];
            
            if(child.str != null){
                ans.add(child.str);
                child.str = null;
            } 
            
            //marking visited
            visited[i][j] = true;
            
            //call to 4 adjacent sides
            for(int[] dir : dirs){
                int rowdash = i + dir[0];
                int coldash = j + dir[1];
                
                if(rowdash < 0 || coldash < 0 || rowdash >= board.length || coldash >= board[0].length || visited[rowdash][coldash] == true) continue;
                
                dfs(board, rowdash, coldash, child, ans, visited);
            }
            
            visited[i][j] = false;
        }
    }
}