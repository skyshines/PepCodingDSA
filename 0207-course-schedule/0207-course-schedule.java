class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for(int[] arr : prerequisites){
            indegree[arr[1]]++;
            graph.get(arr[0]).add(arr[1]);
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.addLast(i);
            }
        }
        
        int count = 0;
        
        while(queue.size() > 0){
            int rem = queue.removeFirst();
            count++;
            
            for(int nbr : graph.get(rem)){
                indegree[nbr]--;
                
                if(indegree[nbr] == 0){
                    queue.addLast(nbr);
                }
            }
        }
        
        return count == numCourses;
        
    }
}