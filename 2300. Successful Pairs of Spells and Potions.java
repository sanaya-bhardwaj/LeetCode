//You are given two positive integer arrays spells and potions, of length n and m respectively,
//where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
//You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
//Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // sorting potions so that if we find the least potion we dont have to search more O(mLogm)
        Arrays.sort(potions);
       
    for(int i=0;i<spells.length;i++){
        //for each spell finding the number and storing without using any extra space
        spells[i]=binarySearch(spells[i],potions,success);

    }
    return spells;
        
    }
    public int binarySearch(int num,int[] potions,long success){
        
        int left=0;
        int n=potions.length;
        int right=n-1;
        // BINARY SEARCH O(Longm)
        while(left<right){
            int mid=(left+right)/2;
            if((long)num*potions[mid]<success){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        //if last element check if its included cause aur algo can come and stop here even if its not included
        if(left==n-1){
            if((long)num*potions[left]<success){
                return 0;
            }
        }
        // return the number of elements to the right of pointer
        return n-left;

    }
}
