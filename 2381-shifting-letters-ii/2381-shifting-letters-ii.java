class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length()];
        
        for(int[] shift : shifts){
            int si = shift[0];
            int ei = shift[1];
            int inc = shift[2] == 1 ? 1 : -1;
            
            arr[si] +=  inc;
            if(ei + 1 < s.length()) arr[ei + 1] += -inc;
        }
        
        int sum = 0;
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < s.length(); i++){
            sum += arr[i];
            arr[i] = sum;
            
            int change = arr[i] + (s.charAt(i) - 'a');
            change = change % 26;
            if(change < 0) change += 26;
            
            sb.append((char)(change + 'a'));
        }
        
        return sb.toString();
    }
}

/*


            int change = arr[i] + (s.charAt(i) - 'a');
            change = change % 26;
            if(change < 0) change += 26;
            
            sb.append((char)(change + 'a'));

*/