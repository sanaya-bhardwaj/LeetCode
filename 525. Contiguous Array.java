//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count--;
            else
                count++;

            if (map.containsKey(count))
                maxLen = Math.max(maxLen, i - map.get(count));
            else
                map.put(count, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 1, 0, 1, 1, 0, 1};
        System.out.println("Maximum length of contiguous subarray: " + solution.findMaxLength(nums));
    }
}
