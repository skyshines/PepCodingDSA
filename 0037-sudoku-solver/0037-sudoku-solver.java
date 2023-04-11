class Solution {
    static boolean flag;
    public void solver(char[][] board, int i, int j){
        if(i == board.length){
            flag = true;
            return;
        }
        
        
        int ni = 0;
        int nj = 0;
        
        if(j == board[0].length - 1){
            ni = i + 1;
            nj = 0;
        }else{
            ni = i;
            nj = j + 1;
        }
        
        if(board[i][j] != '.'){
            solver(board, ni, nj);
        }else{
            for(int pv = 1; pv <= 9; pv++){
                if(isValid(board, i, j, (pv + "").charAt(0)) == true){
                    board[i][j] = (pv + "").charAt(0);
                    
                    solver(board, ni, nj);
                    
                    if(flag == true){
                        return;
                    }
                     
                    board[i][j] = '.';
                }
            }
        }
    }
    
    public boolean isValid(char[][] board,int row, int col,char val){
        //row
        for(int j = 0; j < board[0].length; j++){
            if(board[row][j] == val){
                return false;
            }
        }
        
        //col
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == val){
                return false;
            }
        }
        
        //submatrix
        int si = row / 3 * 3;
        int sj = col / 3 * 3;
        
        for(int i = si; i < si + 3; i++){
            for(int j = sj; j < sj + 3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        flag = false;
        solver(board, 0, 0);
    }
}