//You are given an array of n strings strs, all of the same length.
//The strings can be arranged such that there is one on each line, making a grid.
//For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
//abc
//bce
//cae
//You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
//Return the number of columns that you will delete.

class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int j = 0; j < strs[0].length(); j++)
            res += isUnsorted(strs, j);
        return res;
    }

    private int isUnsorted(String[] strs, int j) {
        for (int i = 1; i < strs.length; i++)
            if (strs[i].charAt(j) < strs[i - 1].charAt(j))
                return 1;
        return 0;
    }
}
