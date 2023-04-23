class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> hm;
    ArrayList<Integer> list;
    Random r;
    
    public RandomizedCollection() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val) == true){
            hm.get(val).add(list.size());
            list.add(val);
            return false;
        }else{
            hm.put(val, new HashSet<>());
            hm.get(val).add(list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val) == true){
            int removeIdx = 0;
            for(int numIdx : hm.get(val)){
                removeIdx = numIdx;
                break;
            }
            
            hm.get(val).remove(removeIdx);
            if(hm.get(val).size() == 0){
                hm.remove(val);
            }
            
            if(removeIdx == list.size() - 1){
                list.remove(list.size() - 1);
            }else{
                list.set(removeIdx, list.get(list.size() - 1));
                hm.get(list.get(removeIdx)).remove(list.size() - 1);
                hm.get(list.get(removeIdx)).add(removeIdx);
                list.remove(list.size() - 1);
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
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */