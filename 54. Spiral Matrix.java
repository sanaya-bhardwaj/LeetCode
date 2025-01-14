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
