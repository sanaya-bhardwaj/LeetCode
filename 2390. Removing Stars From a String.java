//You are given a string s, which contains stars *.
//In one operation, you can:
//Choose a star in s.
//Remove the closest non-star character to its left, as well as remove the star itself.
//Return the string after all stars have been removed.
//Note:
//The input will be generated such that the operation is always possible.
//It can be shown that the resulting string will always be unique.

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char next  = s.charAt(i);
            if(next == '*'){
                st.pop();
            }
            else{
                st.push(next);
            }
        }
    StringBuilder sb = new StringBuilder();
        String result;
        while (!st.isEmpty()) {
                sb.append(st.pop());
            }
        
        return sb.reverse().toString();
    }
}
