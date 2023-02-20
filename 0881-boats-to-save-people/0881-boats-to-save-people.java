class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        //target sum pair
        
        int i = 0;
        int j = people.length - 1;
        int count = 0;
        
        while(i <= j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                i++;
                j--;
                count++;
            }else{
                j--;
                count++;
            }
        }
        
        return count;
    }
}