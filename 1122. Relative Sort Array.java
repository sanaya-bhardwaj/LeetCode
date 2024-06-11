//Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
//Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] ans = new int[arr1.length];
    int[] count = new int[1001];
    int i = 0;

    for (int a : arr1)
      ++count[a];

    for (int a : arr2)
      while (count[a]-- > 0)
        ans[i++] = a;

    for (int num = 0; num < 1001; ++num)
      while (count[num]-- > 0)
        ans[i++] = num;

    return ans;
  }
}
