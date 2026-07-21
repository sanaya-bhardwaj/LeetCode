/*You are given a binary string s of length n, where:
'1' represents an active section.
'0' represents an inactive section.
You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
Return the maximum number of active sections in s after making the optimal trade.
Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do not contribute to the final count.*/

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int count1 = 0;

        int block1 = 0;
        int block2 = 0;
        int maxx = 0;

        int i = 0;
        while(i<n){
            char ch = arr[i];

            if(ch=='0') {
                block1++;
                i++;
            }

            else{
                while(i<n && arr[i]=='1'){
                    i++;
                    count1++;
                }
                
                while(i<n && arr[i]=='0'){
                    i++;
                    block2++;
                }

                if(block1!=0 && block2!=0) maxx = Math.max(maxx, block1+block2);
                block1 = block2;
                block2 = 0;
            }

        }

        return count1 + maxx;

    }
}
