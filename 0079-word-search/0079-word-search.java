class Solution {
    public boolean findWord(char[][] board,int i,int j,String word, int idx,boolean[][] visited){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true){
            return false;
        }
        
        visited[i][j] = true;
        
        if(word.charAt(idx) == board[i][j]){
            if(idx == word.length() - 1){
                visited[i][j] = false;
                return true;
            }
            
            boolean top = findWord(board,i - 1,j,word,idx + 1,visited);
            
            if(top){
                visited[i][j] = false; return true;
            }
            
            boolean left = findWord(board,i,j - 1,word,idx + 1,visited);
            
            if(left){
                visited[i][j] = false; return true;
            }
            
            boolean down = findWord(board,i + 1,j,word,idx + 1,visited);
            
            if(down){
                visited[i][j] = false; return true;
            }
            
            boolean right = findWord(board,i,j + 1,word,idx + 1,visited);
            
            
            visited[i][j] = false;

            return right;            
            
            
        }else{
            visited[i][j] = false;
            return false;
        }
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    boolean wordFound = findWord(board,i,j,word,0,visited);
                    if(wordFound == true) return true;
                }
                
            }
        }
        
        return false;
    }
}