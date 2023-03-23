class Solution {
    public int nextGreaterElement(int n) {
        if(n == (1 << 31) - 1) return -1;
        
        //converting string to char array for easy traversal
        char[] arr = Integer.toString(n).toCharArray();
        
        //finding first dip
        int i = arr.length - 2;
        
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }
        
        if(i == -1) return -1;
        
        int j = arr.length - 1;
        
        //finding just greater element of ith index
        while(arr[i] >= arr[j]) j--;
        
        //swapping with just greater element
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        StringBuilder sb = new StringBuilder();
        
        //add till ith index
        for(int k = 0; k <= i; k++){
            sb.append(arr[k]);
        }
        
        
        //add buit oppossite to reverse from i + 1 to end;
        for(int k = arr.length - 1; k > i; k--){
            sb.append(arr[k]);
        }
        
        long val = Long.parseLong(sb.toString());
        
        if(val > 1L * ((1 << 31) - 1)) return -1;
        return (int)val;
    }
}