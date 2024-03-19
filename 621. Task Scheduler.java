//You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. 
//Each cycle or interval allows the completion of one task. 
//Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
//​Return the minimum number of intervals required to complete all tasks.

//SOLUTION:

import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        Arrays.sort(taskCounts);
        int maxFrequency = taskCounts[25] - 1;
        int idleSlots = maxFrequency * n;

        for (int i = 24; i >= 0 && taskCounts[i] > 0; i--) {
            idleSlots -= Math.min(taskCounts[i], maxFrequency);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int coolingTime = 2;
        System.out.println(solution.leastInterval(tasks, coolingTime)); // Output: 8
    }
}
