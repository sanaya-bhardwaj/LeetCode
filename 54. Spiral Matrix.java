//Given an m x n matrix, return all elements of the matrix in spiral order.

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
		int size = matrix.length * matrix[0].length;
		int i = 0, j = 0;
		int nextI = 1, nextJ = 1;
		int startI = 1, startJ = 0;
		int endI = matrix.length-1, endJ = matrix[0].length-1;
		while(list.size() < size) {
			
			//right
			while(j <= endJ) {
				list.add(matrix[i][j]);
				if(list.size() == size)
					return list;
				j++;
			}
			i++;
            j--;
			//down
			while(i <= endI) {
				list.add(matrix[i][j]);
				if(list.size() == size)
					return list;
				i++;
			}
			i--;
            j--;
			//left
			while(j >= startJ) {
				list.add(matrix[i][j]);
				if(list.size() == size)
						return list;
				j--;
			}
			j++;
            i--;
			//up
			while(i >= startI) {
				list.add(matrix[i][j]);
				if(list.size() == size)
					return list;
				i--;
			}
			i = nextI;
            j = nextJ;
			nextI++;
            nextJ++;
			startI++;
            startJ++;
			endI--;
            endJ--;
        }
        return list;
    }
}





class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Result list to store the spiral order
        List result = new ArrayList<>();

        // Initialize boundaries
        int top = 0;                        // Starting row
        int bottom = matrix.length - 1;     // Ending row
        int left = 0;                       // Starting column
        int right = matrix[0].length - 1;   // Ending column

        // Loop until all elements are traversed
        while (top <= bottom && left <= right) {

            // Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }

        // Return the spiral order result
        return result;
    }
}
