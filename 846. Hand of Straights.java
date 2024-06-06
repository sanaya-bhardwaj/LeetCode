//Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
//Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    TreeMap<Integer, Integer> count = new TreeMap<>();

    for (final int card : hand)
      count.merge(card, 1, Integer::sum);

    for (final int start : count.keySet()) {
      final int value = count.getOrDefault(start, 0);
      if (value > 0)
        for (int i = start; i < start + groupSize; ++i)
          if (count.merge(i, -value, Integer::sum) < 0)
            return false;
    }

    return true;
  }
}
