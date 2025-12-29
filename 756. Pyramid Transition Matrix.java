//You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains one less block than the row beneath it and is centered on top.
//To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.
//For example, "ABC" represents a triangular pattern with a 'C' block stacked on top of an 'A' (left) and 'B' (right) block. Note that this is different from "BAC" where 'B' is on the left bottom and 'A' is on the right bottom.
//You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.
//Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.

class Solution {
    Map<String, List<Character>> rules = new HashMap<>();
    Set<String> bad = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            rules.computeIfAbsent(s.substring(0, 2), k -> new ArrayList<>())
                 .add(s.charAt(2));
        }
        return dfs(bottom, 0, new StringBuilder());
    }

    private boolean dfs(String row, int idx, StringBuilder next) {
        if (row.length() == 1) return true;

        if (idx == row.length() - 1) {
            String nextRow = next.toString();
            if (bad.contains(nextRow)) return false;
            boolean ok = dfs(nextRow, 0, new StringBuilder());
            if (!ok) bad.add(nextRow);
            return ok;
        }

        String key = row.substring(idx, idx + 2);
        if (!rules.containsKey(key)) return false;

        for (char c : rules.get(key)) {
            next.append(c);
            if (dfs(row, idx + 1, next)) return true;
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}
