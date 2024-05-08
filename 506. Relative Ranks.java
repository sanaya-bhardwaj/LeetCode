//You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
//The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

//The 1st place athlete's rank is "Gold Medal".
//The 2nd place athlete's rank is "Silver Medal".
//The 3rd place athlete's rank is "Bronze Medal".
//For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
//Return an array answer of size n where answer[i] is the rank of the ith athlete.

class Solution {
  public String[] findRelativeRanks(int[] nums) {
    final int n = nums.length;
    String[] ans = new String[n];
    List<Integer> indices = new ArrayList<>();

    for (int i = 0; i < n; ++i)
      indices.add(i);

    Collections.sort(indices, (a, b) -> nums[b] - nums[a]);

    for (int i = 0; i < n; ++i)
      if (i == 0)
        ans[indices.get(0)] = "Gold Medal";
      else if (i == 1)
        ans[indices.get(1)] = "Silver Medal";
      else if (i == 2)
        ans[indices.get(2)] = "Bronze Medal";
      else
        ans[indices.get(i)] = String.valueOf(i + 1);

    return ans;
  }
}
