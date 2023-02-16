class Solution {
    
    
    public int countBattleships(char[][] board) {
        int count = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != 'X') continue;
                
                if(i == 0 && j == 0){
                    count++;
                }else if(i == 0){
                    if(board[i][j - 1] != 'X') count++;
                }else if(j == 0){
                    if(board[i - 1][j] != 'X') count++;
                }else{
                    if(board[i][j - 1] != 'X' && board[i - 1][j] != 'X') count++;
                }
            }
            
            
        }
        
        return count;
    }
}