class Solution {
    public void solve(char[] arr, int j, int k){
        //deciding which type of segment
        
        if(arr[j] == 'L' && arr[k] == 'L'){
            for(int i = j + 1; i <= k - 1; i++) arr[i] = 'L';
        }else if(arr[j] == 'R' && arr[k] == 'R'){
            for(int i = j + 1; i <= k - 1; i++) arr[i] = 'R';
        }else if(arr[j] == 'L' && arr[k] == 'R'){
            //doing nothing
        }else{
           int diff = k - j;
           int mid = (k + j) / 2; 
           if(diff % 2 == 1){
            // even dots
               for(int i = j + 1; i <= mid; i++) arr[i] = 'R';
               for(int i = mid + 1; i <= k - 1; i++) arr[i] = 'L';
               
           }else{
              // odd dots
               
              for(int i = j + 1; i <= mid - 1; i++) arr[i] = 'R'; 
              for(int i = mid + 1; i <= k - 1; i++) arr[i] = 'L'; 
               
           } 
        }
    }
    public String pushDominoes(String dominoes) {
        char[] arr = new char[dominoes.length() + 2];
        
        arr[0] = 'L';
        arr[arr.length - 1] = 'R';
        
        for(int i = 1; i < arr.length - 1; i++){
            arr[i] = dominoes.charAt(i - 1);
        }
        
        int j = 0;
        int k = j + 1;
        
        while(k < arr.length){
            //skipping the dots
            while(arr[k] == '.') k++;
            
            //solving tyhe segment
            solve(arr, j , k);
            
            //moving to next segment
            j = k;
            k = j + 1;
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 1; i < arr.length - 1; i++) sb.append(arr[i]);
        
        return sb.toString();
        
    }
}