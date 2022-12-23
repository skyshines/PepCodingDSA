class Solution {
    public boolean solution2(String s1, String s2, String s3){
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= s1.length(); i++){
            if(dp[i - 1][0] == false){
                break;
            }else{
                char ch1 = s1.charAt(i - 1);
                char ch2 = s3.charAt(i - 1);
                dp[i][0] = (ch1 == ch2);
            }
        }
        
        for(int j = 1; j <= s2.length(); j++){
            if(dp[0][j - 1] == false){
                break;
            }else{
                char ch1 = s2.charAt(j - 1);
                char ch2 = s3.charAt(j - 1);
                dp[0][j] = (ch1 == ch2);
            }
        }
        
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                int s1i = i - 1; int s2i = j - 1; int s3i = i + j - 1;
                char ls1ch = s1.charAt(s1i);
                char ls2ch = s2.charAt(s2i);
                char ls3ch = s3.charAt(s3i);
                
                
                boolean flag = false;
                if(ls3ch == ls1ch){
                    flag = dp[i - 1][j];
                }
                if(flag == false && ls3ch == ls2ch){
                    flag = dp[i][j - 1];
                }
                dp[i][j] = flag;
            }
        }
        
        return dp[s1.length()][s2.length()];
        
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
         if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        return solution2(s1,s2,s3);
    }
}

/*
recurrsion with memoization
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


*/