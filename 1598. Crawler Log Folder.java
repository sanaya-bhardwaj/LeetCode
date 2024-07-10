//The Leetcode file system keeps a log each time some user performs a change folder operation.
//The operations are described below:
//"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
//"./" : Remain in the same folder.
//"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
//You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
//The file system starts in the main folder, then the operations in logs are performed.
//Return the minimum number of operations needed to go back to the main folder after the change folder operations.

class Solution {
    public int minOperations(String[] logs) {
        // Initialize the steps counter to 0.
        int steps = 0;
      
        // Iterate through each log entry.
        for (String log : logs) {
            // If the log entry is "../", move one directory up.
            if ("../".equals(log)) {
                // Ensure that steps cannot be negative.
                steps = Math.max(0, steps - 1);
            // If the log entry is not a "." or "..", move one directory deeper.
            } else if (!"./".equals(log)) {
                // Increment the steps counter.
                ++steps;
            }
            // No action required for "./" as it means stay in the current directory.
        }
        // Return the minimum number of operations to end up back at the main folder.
        return steps;
    }
}
