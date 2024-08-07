//Given an array of characters chars, compress it using the following algorithm:
//Begin with an empty string s. For each group of consecutive repeating characters in chars:
//If the group's length is 1, append the character to s.
//Otherwise, append the character followed by the group's length.
//The compressed string s should not be returned separately, but instead, be stored in the input character array chars. 
//Note that group lengths that are 10 or longer will be split into multiple characters in chars.
//After you are done modifying the input array, return the new length of the array.
//You must write an algorithm that uses only constant extra space.

//Intuition
//Use an external string initially and use that to change the chars values.

//Time complexity:
//O(n)


//Code
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 0) return 0;
        
        StringBuilder s = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                s.append(chars[i - 1]);
                if (count > 1) {
                    s.append(count);
                }
                count = 1;  
            }
        }
        
        s.append(chars[n - 1]);
        if (count > 1) {
            s.append(count);
        }
        
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        
        return s.length();
    }
}
