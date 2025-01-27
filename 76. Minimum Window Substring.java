//Given two strings s and t of lengths m and n respectively, return the minimum window 
//substring of s such that every character in t (including duplicates) is included in the window. 
//If there is no such substring, return the empty string "".
//The testcases will be generated such that the answer is unique.

  class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in `t`
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, start = 0, minLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> ans = new HashMap<>();
        int required = map.size();
        int formed = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            ans.put(c, ans.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && ans.get(c).equals(map.get(c))) {
                formed++;
            }

            // Contract the window
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the minimum length window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                ans.put(c, ans.get(c) - 1);
                if (map.containsKey(c) && ans.get(c) < map.get(c)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
