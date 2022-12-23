class Solution {
    public boolean solution1(String s1, String s2, String s3,int i, int j,Boolean[][] dp){
        if(i == s1.length() && j == s2.length()){
            dp[i][j] = true;
            return true;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int k = i + j;
        
        boolean flag = false;
        
        if((i < s1.length() && s1.charAt(i) == s3.charAt(k)) && (j < s2.length() && s2.charAt(j) == s3.charAt(k))){
            boolean flag1 = solution1(s1, s2, s3, i+1, j,dp);
            if(flag1 == true){
                flag = true;
            }else{
                flag = solution1(s1, s2, s3, i, j+1,dp);
            }
        }else if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            flag = solution1(s1, s2, s3, i+1, j,dp);
        }else if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            flag = solution1(s1, s2, s3, i, j+1,dp);
        }else{
            flag = false;
        }
        
        dp[i][j] = flag;
        return flag;
    }
    
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return solution1(s1,s2,s3,0,0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }
}