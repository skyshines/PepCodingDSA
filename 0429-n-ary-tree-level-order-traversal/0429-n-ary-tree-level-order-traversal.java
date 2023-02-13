/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        
        if(root == null) return ls;
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        
        int size = 0;
        
        while(queue.size() > 0){
            List<Integer> ans = new ArrayList<>();
            size = queue.size();
            
            for(int i = 0; i < size; i++){
                //remove,print,children add
                
                Node temp = queue.remove();
                ans.add(temp.val);
                
                for(Node child : temp.children){
                    queue.add(child);
                }
                
            }
            
            ls.add(ans);
        }
        
        return ls;
    }
}