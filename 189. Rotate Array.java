//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }        
    }
}


//2nd solution

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        Reverse(nums, 0, n-1);
        Reverse(nums, 0, k-1);
        Reverse(nums, k, n-1);
    }

    private void Reverse(int[] arr, int i, int j){
        while(i<j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
        }
    }
}
