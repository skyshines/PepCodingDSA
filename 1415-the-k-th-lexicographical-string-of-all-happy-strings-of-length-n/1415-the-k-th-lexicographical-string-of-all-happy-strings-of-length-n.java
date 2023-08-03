class Solution {
    public String getHappyString(int n, int k) {
        LinkedList<String> queue = new LinkedList<>();
        
        queue.addLast("a");
        queue.addLast("b");
        queue.addLast("c");
        
        int i = 1;
        
        while(i < n){
            int size = queue.size();
            
            for(int j = 0; j < size; j++){
                String rem = queue.removeFirst();
                
                char ch = rem.charAt(rem.length() - 1);
                
                if(ch == 'a'){
                    queue.addLast(rem + "b");
                    queue.addLast(rem + "c");
                }else if(ch == 'b'){
                    queue.addLast(rem + "a");
                    queue.addLast(rem + "c");
                }else{
                    queue.addLast(rem + "a");
                    queue.addLast(rem + "b");
                }
            }
            
            i++;
        }
        
        String res = "";
        
        while(queue.size() > 0){
            String rem = queue.removeFirst();
            
            if(k == 1){
                return rem;
            }
            
            k--;
        }
        
        return res;
    }
}