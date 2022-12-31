keep removing valid pair from the string, remaining will be invalid
when we encounter '(' we increment left
otherwise ')' if we had encountered
if left are there , which forms a pair we decrement left by 1|
otheriwse if no left is there the we increment right
​
class Solution {
public int minAddToMakeValid(String s) {
int left=0, right=0;
for(int i=0;i<s.length();i++) {
char curr = s.charAt(i);
if (curr == '(')
left++;
else if(curr == ')')
if(left > 0)
left--;
else
right++;
}
return left+right;
}
}
​
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181132/C%2B%2BJavaPython-Straight-Forward-One-Pass