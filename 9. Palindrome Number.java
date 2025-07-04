//Given an integer x, return true if x is a palindrome,
//and false otherwise.

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


class Solution {
    public boolean isPalindrome(int x) {
        int dup=x,lastdigit,rev=0;
        if(x<0){
            return false;
        }
        while(x!=0){
            lastdigit=x%10;
            x=x/10;
            rev=rev*10+lastdigit;
        } 
        if(rev==dup){
            return true;
        }else{
            return false;
        }
    }  
}
