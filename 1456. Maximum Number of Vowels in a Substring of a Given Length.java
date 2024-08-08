//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

class Solution {
    public int maxVowels(String str, int k) {
        int arr[]=new int[str.length()];
        char ch1=str.charAt(0);
        if(ch1=='a'||ch1=='i'||ch1=='e'||ch1=='o'||ch1=='u')
        arr[0]=1;
        for(int i=1;i<str.length();i++){
            char ch=str.charAt(i);
           if(ch=='a'||ch=='i'||ch=='e'||ch=='o'||ch=='u')
           arr[i]=arr[i-1]+1;
           else
           arr[i]=arr[i-1];
        }
        int max=arr[k-1];
        System.out.println(arr[k-1]);
        int a=0;
        for(int i=k;i<str.length();i++){
            int val=arr[i]-arr[a++];
            if(val>max)
            max=val;
        }
        return max;
    }
}
