//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        //using map to store freq of nums
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //using ArrayList to store majority ele's
        ArrayList<Integer> majority = new ArrayList<>();
        for(Integer key : map.keySet()) { //foreach loop to access keys & val in map
            if(map.get(key) > n/3) {
                majority.add(key);
            }
        }

        return majority;
        
    }
}
