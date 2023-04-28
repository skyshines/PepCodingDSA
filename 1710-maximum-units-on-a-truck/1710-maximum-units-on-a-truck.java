class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });
        
        int truckVal = 0;
        int truckCap = truckSize;
        
        int i = 0;
        
        while(truckCap > 0 && i < boxTypes.length){
            if(boxTypes[i][0] > truckCap){
               truckVal += boxTypes[i][1] * truckCap;
                break;
            }else{
                truckVal += boxTypes[i][1] * boxTypes[i][0];
                truckCap -= boxTypes[i][0];
            }
            
            i++;
        }
        
        return truckVal;
    }
}