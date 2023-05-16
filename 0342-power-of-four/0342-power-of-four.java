class Solution {
    public boolean isPowerOfFour(int n) {
        int evenMask = 0b01010101010101010101010101010101;
        return (n > 0) && ((n & n - 1) == 0b0) && ((n & evenMask) != 0b0);
    }
}