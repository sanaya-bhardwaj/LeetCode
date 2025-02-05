//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        return (subset(nums, 0, 0, list));
    }

    static List<List<Integer>> subset(int[] nums, int i, int s, List<List<Integer>> list) {
        if (i == nums.length) {
            return list;
        }
        List<List<Integer>> temp = new ArrayList<>(list);
        int startIndex = (i > 0 && nums[i] == nums[i - 1]) ? s : 0;
        s = list.size();
        for (int j = startIndex; j < s; j++) {
            List<Integer> temp2 = new ArrayList<>(list.get(j));
            temp2.add(nums[i]);
            list.add(temp2);
        }
        return subset(nums, i + 1, s, list);
    }
}
