//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of tempList to result
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements or duplicates (nums[i] == nums[i-1]) when the previous one is not used
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true; // Mark as used
            tempList.add(nums[i]);
            backtrack(nums, result, tempList, used);
            used[i] = false; // Unmark
            tempList.remove(tempList.size() - 1); // Backtrack
        }
    }
}
