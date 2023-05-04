class Solution {
    public class Trie{
        Node root;
        
        Trie(){
            root = new Node();
        }
        
        public class Node{
            Node left;
            Node right;
        }
        
        public void insert(int val){
            Node curr = root;
            int bitIndex = 30;
            
            while(bitIndex >= 0){
                int mask = (1 << bitIndex);
                int bit = (mask & val) > 0 ? 1 : 0;
                
                if(bit == 0){
                    if(curr.left == null){
                        curr.left = new Node();
                    }
                    
                    curr = curr.left;
                }else if(bit == 1){
                    if(curr.right == null){
                        curr.right = new Node();
                    }
                    
                    curr = curr.right;
                }
                
                bitIndex--;
            }
            
        }
        
        public int query(int val){
            int ans = 0;
            Node curr = root;
            int bitIndex = 30;
            
            while(bitIndex >= 0){
                int mask = (1 << bitIndex);
                int bit = (mask & val) > 0 ? 1 : 0;
                
                if(bit == 0){
                    if(curr.left != null){
                        curr = curr.left;
                    }else{
                        ans = (ans | mask);
                        curr = curr.right;
                    }
                }else if(bit == 1){
                    if(curr.right != null){
                        ans = (ans | mask);
                        curr = curr.right;
                    }else{
                        curr = curr.left;
                    }
                }
                
                bitIndex--;
            }
            
            return ans;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for(int num : nums){
            trie.insert(num);
        }
        
        int max = 0;
        
        for(int num : nums){
            int find = (~num);
            int res = trie.query(find);
            
            if((num ^ res) > max) max = (num ^ res);
        }
        
        return max;
    }
}