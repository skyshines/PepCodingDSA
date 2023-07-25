class Solution {
    static boolean flag = true;
    static boolean[] isprime = new boolean[5 * 1000000];
    
    public int countPrimes(int n) {
        if(flag == true){
            for(int i = 2; i * i <= isprime.length; i++){
                if(isprime[i] == false){
                    for(int j = i + i; j < isprime.length; j += i){
                        isprime[j] = true;
                    }
                }
            }
            
            flag = false;
        }
        
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isprime[i] == false) count++;
        }
        
        return count;
    }
}