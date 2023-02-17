//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')'){
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == ']'){
                if(st.size() > 0 && st.peek() == '['){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == '}'){
                if(st.size() > 0 && st.peek() == '{'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        
        return st.size() == 0;
    }
} 