import java.util.HashMap;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int total = 0;

        // Step 1: Count frequency of each element
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);

            // Update max frequency
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        // Step 2: Sum frequencies of elements with max frequency
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                total += freq;
            }
        }

        return total;
    }
}
