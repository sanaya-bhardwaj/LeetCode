//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty())
      return new ArrayList<>();

    List<String> ans = new ArrayList<>();

    dfs(digits, 0, new StringBuilder(), ans);
    return ans;
  }

  private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
                                                  "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
    if (i == digits.length()) {
      ans.add(sb.toString());
      return;
    }

    for (final char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
      sb.append(c);
      dfs(digits, i + 1, sb, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
