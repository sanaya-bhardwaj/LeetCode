//Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
//answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
//answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
//Note that the integers in the lists may be returned in any order.

//Algorithm:
	//1. First create 2 sets. Then add nums1 elements to set1, and nums2 to set2.This will give us 2 sets with unique elements only.
	//2. Now,  just iterate to all elements of set1 and add those elements to first sublist of result list, which are not in set2.
	//3. Similarly, iterate to all elements of set2 and add those elements to second sublist of result list, which are not in set1.
	//4. Now, we got our result list.
//Complexity:
	//Time: O(n)  : n is length of input array with bigger length
	//Space: O(m) : m is size of hashset with bigger length
//code
class Solution {
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();                           // create 2 hashsets
		Set<Integer> set2 = new HashSet<>();
		for(int num : nums1){ set1.add(num); }                         // add nums1 elements to set1
		for(int num : nums2){ set2.add(num); }                         // add nums2 elements to set2
		
		List<List<Integer>> resultList = new ArrayList<>();             // Initialize result list with 2 empty sublists that we will return
		resultList.add(new ArrayList<>());
		resultList.add(new ArrayList<>());

		for(int num : set1){                                            // just iterate to all elements of set1
			if(!set2.contains(num)){ resultList.get(0).add(num); }      // add those elements to first sublist of result list, which are not in set2.
		}
		for(int num : set2){                                            // just iterate to all elements of set2
			if(!set1.contains(num)){ resultList.get(1).add(num); }      // add those elements to first sublist of result list, which are not in set1
		}
		return resultList;
	}
}
