class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean findWord(char[][] board,int i,int j,String word, int idx){
        if(idx == word.length()) return true;
        
        char currentCh = board[i][j];
        board[i][j] = '@';
        
        for(int k = 0; k < 4; k++){
            int row = i + dir[k][0];
            int col = j + dir[k][1];
            
            if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '@'){
                continue;
            }
            
            if(board[row][col] == word.charAt(idx)){
                boolean b = findWord(board,row,col,word,idx + 1);
                if(b == true){
                    return true;
                }
            }
            
        }
        
        board[i][j] = currentCh;
        return false;
            
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    boolean wordFound = findWord(board,i,j,word,1);
                    if(wordFound == true) return true;
                }
                
            }
        }
        
        return false;
    }
}