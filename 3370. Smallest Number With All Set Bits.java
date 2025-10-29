//You are given a positive number n.
//Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits

class Solution {
    public int smallestNumber(int n) {
        int x = n;
        while ((x & (x + 1)) != 0){
            x++;
        }
        
        return x;
    }
}

 
