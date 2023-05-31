/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void serialize(TreeNode node,StringBuilder sb){
        if(node == null){
            if(sb.length() != 0) sb.append(",");
            sb.append("null");
            return;
        }
        
        if(sb.length() != 0) sb.append(",");
        sb.append(node.val);
        
        serialize(node.left, sb);
        serialize(node.right, sb);
        
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    class Pair{
        TreeNode node;
        int state;
        
        Pair(TreeNode node,int state){
            this.node = node;
            this.state = state;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr[0].equals("null")) return null;
        
        
        Stack<Pair> st = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        st.push(new Pair(root, 0));
        int i = 1;
        while(i < arr.length){
            if(st.peek().state == 0){
                if(arr[i].equals("null")){
                    st.peek().node.left = null;
                   st.peek().state++;
                    i++;
                }else{
                    st.peek().node.left = new TreeNode(Integer.parseInt(arr[i]));
                    st.peek().state++;
                    st.push(new Pair(st.peek().node.left, 0));
                    i++;
                }
            }else if(st.peek().state == 1){
                if(arr[i].equals("null")){
                    st.peek().node.right = null;
                   st.peek().state++;
                    i++;
                }else{
                    st.peek().node.right = new TreeNode(Integer.parseInt(arr[i]));
                    st.peek().state++;
                    st.push(new Pair(st.peek().node.right, 0));
                    i++;
                }
            }else if(st.peek().state == 2){
                st.pop();
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));