class Solution {
    // interval length -> end - start + 1
    // time for which function execute -> tottal interval - child time
    
    class Pair{
        int id; // function ID
        int st; // start time
        int cht; // child time
        
        Pair(int id, int st, int cht){
            this.id = id;
            this.st = st;
            this.cht = cht;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[n];
        
        for(String log : logs){
            String[] state = log.split(":");
            
            if(state[1].equals("start")){
                int id = Integer.parseInt(state[0]);
                int sti = Integer.parseInt(state[2]);
                st.push(new Pair(id,sti,0));
            }else{ //end
                int end = Integer.parseInt(state[2]);
                Pair p = st.pop();
                int total_interval = end - p.st + 1;
                
                ans[p.id] += total_interval - p.cht;
                if(st.size() > 0){
                    st.peek().cht += total_interval;
                }
                
            }
        }
        
        return ans;
    }
}