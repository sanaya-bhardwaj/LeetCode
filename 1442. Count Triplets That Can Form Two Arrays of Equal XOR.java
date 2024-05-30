//Given an array of integers arr.
//We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
//Let's define a and b as follows:
//a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
//b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
//Note that ^ denotes the bitwise-xor operation.
//Return the number of triplets (i, j and k) Where a == b.

class Solution {
    public int countTriplets(int[] arr) {
        int length = arr.length; // The length of the input array.
        int[] prefixXor = new int[length + 1]; // Prefix XOR array, with an extra slot to handle 0 case.

        // Construct the prefix XOR array where prefixXor[i] is XOR of all elements from start upto i-1.
        for (int i = 0; i < length; ++i) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        int count = 0; // The result count for triplets.

        // Iterate through all possible starts i of subarray (arr[i] to arr[k]).
        for (int i = 0; i < length - 1; ++i) {
            // Iterate through all possible ends j (where i < j <= k) of subarray starting at arr[i].
            for (int j = i + 1; j < length; ++j) {
                // Iterate for all possible ends k of the second subarray, starting from arr[j].
                for (int k = j; k < length; ++k) {
                    // XOR of subarray arr[i] to arr[j-1].
                    int xorA = prefixXor[j] ^ prefixXor[i];
                    // XOR of subarray arr[j] to arr[k].
                    int xorB = prefixXor[k + 1] ^ prefixXor[j];
                  
                    if (xorA == xorB) { // If the XOR of both subarrays is equal, it's a valid triplet.
                        count++; // Increment the count of valid triplets.
                    }
                }
            }
        }

        return count; // Return the final count of triplets.
    }
}
