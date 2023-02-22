class Solution {
    class Pair implements Comparable<Pair>{
        int pos;
        double time;
        
        Pair(int pos,double time){
            this.pos = pos;
            this.time = time;
        }
        
        public int compareTo(Pair other){
            return this.pos - other.pos;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] cardata = new Pair[n];
        
        for(int i = 0; i < position.length; i++){
            int distance = target - position[i];
            double time = ((distance) * (1.0)) / speed[i];
            
            cardata[i] = new Pair(position[i], time);
        }
        
        Arrays.sort(cardata);
        
        //taking data of first fleet
        double currenttime = cardata[n - 1].time;
        int cars = 1;
        
        for(int i = n - 2; i >= 0; i--){
            if(cardata[i].time > currenttime){
                cars++;
                currenttime = cardata[i].time;
            }
        }
        
        return cars;
    }
}