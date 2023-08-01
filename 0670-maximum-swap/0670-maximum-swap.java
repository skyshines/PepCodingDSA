class Solution {
    public void swap(StringBuilder sb, int i, int j){
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        
        int[] idx = new int[10];
        
        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            idx[ch - '0'] = i;
        }
        
        for(int i = 0; i < sb.length(); i++){
            if(false){
                
            }else{
                boolean flag = true;
                
                for(int j = 9; j > sb.charAt(i) - '0'; j--){
                    if(idx[j] > i){
                        flag = false;
                        swap(sb, i, idx[j]);
                        break;
                    }
                }
                
                if(flag == false) break;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}