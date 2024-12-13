//Given an integer x, return true if x is a palindrome,
and false otherwise.

class Solution {
    public boolean isPalindrome(int x) {
         boolean flag=true;
        if(x<0)
            flag=false;
        else{
            int rev=0;
            int num=x;
            while(x!=0)
            {
                rev=rev*10 +(x%10);
                x/=10;
            }
            if(rev!=num)
                flag=false;
        }
        return flag;
    }
}
