//There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
//You are given a string dominoes representing the initial state where:
//dominoes[i] = 'L', if the ith domino has been pushed to the left,
//dominoes[i] = 'R', if the ith domino has been pushed to the right, and
//dominoes[i] = '.', if the ith domino has not been pushed.
//Return a string representing the final state.

class Solution {
    public String pushDominoes(String s) {
        s = "L" + s + "R";
        StringBuilder res = new StringBuilder();
        int prev = 0;
        for (int curr = 1; curr < s.length(); ++curr) {
            if (s.charAt(curr) == '.') continue;
            int span = curr - prev - 1;
            if (prev > 0)
                res.append(s.charAt(prev));
            if (s.charAt(prev) == s.charAt(curr)) {
                for (int i = 0; i < span; ++i)
                    res.append(s.charAt(prev));
            } else if (s.charAt(prev) == 'L' && s.charAt(curr) == 'R') {
                for (int i = 0; i < span; ++i)
                    res.append('.');
            } else {
                for (int i = 0; i < span / 2; ++i)
                    res.append('R');
                if (span % 2 == 1)
                    res.append('.');
                for (int i = 0; i < span / 2; ++i)
                    res.append('L');
            }
            prev = curr;
        }
        return res.toString();
    }
}
