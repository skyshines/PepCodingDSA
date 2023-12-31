class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        int Bus = 0;
        
        for(int[] route : routes){
            for(int stop : route){
                ArrayList<Integer> buses = hm.getOrDefault(stop, new ArrayList<>());
                buses.add(Bus);
                hm.put(stop, buses);
            }
            Bus++;
        }
        
        if(source == target) return 0;
        
        if(hm.containsKey(source) == false || hm.containsKey(target) == false) return -1;
        
        Queue<Integer> queue = new ArrayDeque<>(); // BFS
        
        
        //visited
        HashSet<Integer> busVisited = new HashSet<>();
        HashSet<Integer> busStopVisited = new HashSet<>();
        
        queue.add(source);
        //busStopVisited.add(source); //marking visisted and adding in BFS
        
        int lev = 0;
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i = 0;  i < size; i++)
            {
                int busStop = queue.remove();
                
                //busStopVisited.add(busStop);
                
                if(busStop == target){
                    return lev;
                }else{
                    ArrayList<Integer> buses = hm.get(busStop);
                    
                    for(int bus : buses){
                        if(busVisited.contains(bus) == true) continue;
                        
                        for(int stop : routes[bus]){
                            if(busStopVisited.contains(stop) == true) continue;
                            
                            queue.add(stop);
                            busStopVisited.add(stop);
                        }
                        
                        busVisited.add(bus);
                    }
                }
            }
            
            lev++;
        }
        
        return -1;
    }
}