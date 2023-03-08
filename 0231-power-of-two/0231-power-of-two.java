class Solution {
    public boolean isPowerOfTwo(int n) {
        //Solved Using Bit Manipulation
        //power of 2 has only one set bit
        //n - 1 will turn on the bits after that bit adn will make that bit OFF in n - 1
        //taking and if ans 0 then number power of two otherwise not
        if(n <= 0) return false;
        return (n & n - 1) == 0b0;
    }
}