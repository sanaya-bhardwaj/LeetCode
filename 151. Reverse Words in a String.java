//Given an input string s, reverse the order of the words.
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//Return a string of the words in reverse order concatenated by a single space.
//Note that s may contain leading or trailing spaces or multiple spaces between two words. 
//The returned string should only have a single space separating the words. Do not include any extra spaces.

//Approach

//The input string s is trimmed to remove any leading or trailing spaces using the trim() method.
//The trimmed string is then split into an array of words using the split("\\s+") method. 
//The regular expression "\s+" matches one or more whitespace characters, effectively separating the words.
//A variable out is initialized as an empty string to store the reversed words.
//Starting from the last word in the array (str.length - 1), the loop iterates backwards until the first word (index 0) is reached.
//In each iteration, the current word str[i] is appended to out along with a space (" ") to separate the words.
//Finally, the first word str[0] is appended to out.
//The reversed string of words, stored in out, is returned as the result.

//Complexity
//Time complexity:O(n)
//Space complexity:O(n)

  
//Code

class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }
}
