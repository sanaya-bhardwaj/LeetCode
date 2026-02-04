/*You are given an integer array nums of length n.
A trionic subarray is a contiguous subarray nums[l...r] (with 0 <= l < r < n) for which there exist indices l < p < q < r such that:
nums[l...p] is strictly increasing,
nums[p...q] is strictly decreasing,
nums[q...r] is strictly increasing.
Return the maximum sum of any trionic subarray in nums.*/

class Solution {

    public long maxSumTrionic(int[] nums) {
        
        int n = nums.length;
        long res= -1 * (long)1e16;

        for(int i=1;i<n-2;i++){

            int a = i; 
            int b = i; 

            long net = nums[a];

            while(b+1<n && nums[b+1] < nums[b]){
                net+=(long)nums[b+1];
                b++;
            }

            if(b==a)continue;

            int c= b; 

            long left = 0;
            long right = 0;

            long lx =Integer.MIN_VALUE;
            long rx =Integer.MIN_VALUE;

            while(a-1>=0 && nums[a-1] < nums[a]){
                left+=(long)nums[a-1];
                lx = Math.max(lx, left);
                a--;
            }

            if(a==i)continue;

            while(b+1<n && nums[b+1] > nums[b]){
                right+=(long)nums[b+1];
                rx = Math.max(rx, right);
                b++;
            }

            if(b==c)continue;
            i=b-1;
            res = Math.max( res, lx+rx+net);

        }
        return res;
    }
}
