class Solution {
    class Pair implements Comparable<Pair>{
        int st;
        int et;
        
        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }
        
        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st; 
            }else{
                return this.et - other.et;
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        Pair[] arr = new Pair[intervals.length];
        Stack<Pair> pairs = new Stack<>();
        
        
        for(int i = 0; i < intervals.length; i++){
            int st = intervals[i][0];
            int et = intervals[i][1];
            
            arr[i] = new Pair(st,et);
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < intervals.length; i++){
            int st = arr[i].st;
            int et = arr[i].et;
            
            if(pairs.size() == 0 || pairs.peek().et < st){
                pairs.push(new Pair(st,et));
            }else{
                if(pairs.peek().et >= st){
                    pairs.peek().et = (int)Math.max(pairs.peek().et,et);
                }
            }
        }
        
        int[][] ans = new int[pairs.size()][2];
        
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i][0] = pairs.peek().st;
            ans[i][1] = pairs.peek().et;
            
            pairs.pop();
        }
        
        return ans;
    }
}