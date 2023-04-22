class RandomizedSet {
    HashMap<Integer, Integer> hm;
    ArrayList<Integer> list;
    Random r;
    
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val) == false){
            hm.put(val, list.size());
            list.add(val);
            
            return true;
        }else{
            
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val) == true){
            int remIdx = hm.get(val);
            hm.remove(val);
            
            if(remIdx == list.size() - 1){
                list.remove(list.size() - 1);
            }else{
                list.set(remIdx, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                hm.put(list.get(remIdx), remIdx);
            }
            
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
    
    public int getRandom2() {
        int minIdx = 0;
        int maxIdx = list.size() - 1;
        int range = maxIdx - minIdx + 1;
        
        int idx = (int)Math.random() * range + minIdx;
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */