//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
//(you may want to display this pattern in a fixed font for better legibility)
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows:
//string convert(string s, int numRows);

class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        StringBuffer [] arr = new StringBuffer[numRows]; 
        for(int i=0; i<numRows; i++) arr[i] = new StringBuffer();

        int i=0;
        while(i<n){
            /// verticaly downword
            for(int ind=0; ind<numRows && i<n; ind++){
                arr[ind].append(s.charAt(i++));
            }
            /// bent upword
            for(int ind=numRows-2; ind>0 && i<n; ind--){
                arr[ind].append(s.charAt(i++));
            }
        }
        StringBuffer ans = new StringBuffer();
        for(StringBuffer el : arr){
            ans.append(el);
        }
        return ans.toString();
    }
}
