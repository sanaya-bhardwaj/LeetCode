/*You are given an integer array nums.
A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.
Return the length of the longest balanced subarray.*/

class Solution {
    public int longestBalanced(int[] nums) {
        
        int max = 0;
        int len = nums.length;

        for(int i = 0;i<nums.length;i++)
        {
            int even = 0;
            int odd = 0;
            HashSet<Integer> set = new HashSet<>();

            for(int j =i;j<nums.length;j++)
            {
                if(!set.contains(nums[j]))
                {
                    set.add(nums[j]);
                    if(nums[j] % 2 == 0)
                        even++;
                    else
                        odd++;
                }
                  if(even == odd)
                        max = Math.max(max, (j-i)+1);
            }
        }
        return max;
    }
}
