//An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day.
//The record only contains the following three characters:
//'A': Absent.
//'L': Late.
//'P': Present.
//Any student is eligible for an attendance award if they meet both of the following criteria:
//The student was absent ('A') for strictly fewer than 2 days total.
//The student was never late ('L') for 3 or more consecutive days.
//Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. 
//The answer may be very large, so return it modulo 109 + 7.

class Solution {
  public int checkRecord(int n) {
    final int kMod = 1_000_000_007;
    // dp[i][j] := the length so far with i A's and the last letters are j L's
    long[][] dp = new long[2][3];
    dp[0][0] = 1;

    while (n-- > 0) {
      long[][] prev = Arrays.stream(dp)
                          .map((long[] A) -> A.clone())
                          .toArray((int length) -> new long[length][]);

      // Append a P.
      dp[0][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % kMod;

      // Append an L.
      dp[0][1] = prev[0][0];

      // Append an L.
      dp[0][2] = prev[0][1];

      // Append an A or append a P.
      dp[1][0] =
          (prev[0][0] + prev[0][1] + prev[0][2] + prev[1][0] + prev[1][1] + prev[1][2]) % kMod;

      // Append an L.
      dp[1][1] = prev[1][0];

      // Append an L.
      dp[1][2] = prev[1][1];
    }

    return (int) ((dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % kMod);
  }
}
