//You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. 
//Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
//Return the minimum number of boats to carry every given person.

class Solution {
  public int numRescueBoats(int[] people, int limit) {
    int ans = 0;

    Arrays.sort(people);

    for (int i = 0, j = people.length - 1; i <= j; ++ans) {
      final int remain = limit - people[j--];
      if (people[i] <= remain)
        ++i;
    }

    return ans;
  }
}
