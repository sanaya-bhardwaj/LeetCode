//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;

    int ans = 0;
    int[] hist = new int[matrix[0].length];

    for (char[] row : matrix) {
      for (int i = 0; i < row.length; ++i)
        hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
      ans = Math.max(ans, largestRectangleArea(hist));
    }

    return ans;
  }

  private int largestRectangleArea(int[] heights) {
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i <= heights.length; ++i) {
      while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
        final int h = heights[stack.pop()];
        final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        ans = Math.max(ans, h * w);
      }
      stack.push(i);
    }

    return ans;
  }
}
