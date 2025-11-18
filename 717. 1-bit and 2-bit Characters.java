//We have two special characters:
//The first character can be represented by one bit 0.
//The second character can be represented by two bits (10 or 11).
//Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        final int n=bits.length;
        int i=0;
        while(i<n-1){
            i+=1+bits[i];
        }
        return i==n-1;
    }
}
