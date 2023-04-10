class Solution{
    public String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
         sb.setCharAt(j, temp);
        
        return sb.toString();
        
    }
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                sb.append(board[i][j]);
            }
        }
        
        String source = sb.toString();
        
        int[][] swapIdx = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        
        HashSet<String> visited = new HashSet<>();
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(source);
        visited.add(source);
        
        int lev = 0;
        
        while(queue.size() > 0){
            int size = queue.size();
            
            while(size-- > 0){
               String rem = queue.remove();
                
               if(rem.equals(target) == true){
                   return lev;
               }
                
               int idx = -1;
               for(int i = 0; i < rem.length(); i++){
                   if(rem.charAt(i) == '0'){
                       idx = i;
                       break;
                   }
               }
                
               int[] swapArr = swapIdx[idx]; 
                
               for(int i = 0; i < swapArr.length; i++){
                   String toBeAdded = swap(rem, swapArr[i], idx);
                   
                   if(visited.contains(toBeAdded) == true) continue;
                   
                   queue.add(toBeAdded);
                   visited.add(toBeAdded);
               } 
                
            }
            
            lev++;
        }
        
        return -1;
    }
}