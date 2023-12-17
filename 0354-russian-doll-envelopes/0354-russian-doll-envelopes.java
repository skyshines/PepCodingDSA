class Solution {
    int size;
    
    public int binarySearch(ArrayList<Integer> list, int num){
        int left = 0;
        int right = size - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            
            if(list.get(mid) == num){
                return mid;
            }else if(list.get(mid) > num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        // max number of non overlapping bridges
        
        Arrays.sort(envelopes, (a,b) -> {
            return (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        });
        
        size = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < envelopes.length; i++){
            if(size == 0 || temp.get(size - 1) < envelopes[i][1]){
                temp.add(envelopes[i][1]);
                size++;
            }else{
                temp.set(binarySearch(temp, envelopes[i][1]), envelopes[i][1]);
            }
        }
        
        return size;
    }
}