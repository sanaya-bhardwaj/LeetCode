//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

class Solution {
    public int longestOnes(int[] arr, int k) {
        int max=Integer.MIN_VALUE;int c=0;int v=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
            q.add(i+1);
        }
        for(int i=0;i<arr.length;i++){
            c++;
            if(arr[i]==0)
            {
                v++;
            }
            if(v>k){
                c=(i+1)-q.remove();
                v--;
            }
            
            if(c>max)
            max=c;
        }
        return max;
    }
}
