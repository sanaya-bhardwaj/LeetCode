//Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = c; 
        while (left<=right){
            long cur = left * left + right * right;
            if(cur< c) {
                left++;
            }
            else if (cur > c) {
                right--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
