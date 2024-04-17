//You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
//You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
//There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
//Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
//Return the minimum number of minutes needed to pick up all the garbage.

class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    int[] prefix = new int[travel.length];
    prefix[0] = travel[0];
    for (int i = 1; i < prefix.length; ++i)
      prefix[i] += prefix[i - 1] + travel[i];
    final int timeM = getTime(garbage, prefix, 'M');
    final int timeP = getTime(garbage, prefix, 'P');
    final int timeG = getTime(garbage, prefix, 'G');
    return timeM + timeP + timeG;
  }

  private int getTime(String[] garbage, int[] prefix, char c) {
    int characterCount = 0;
    int lastIndex = -1;
    for (int i = 0; i < garbage.length; ++i) {
      final String s = garbage[i];
      if (s.chars().anyMatch(g -> g == c))
        lastIndex = i;
      characterCount += (int) s.chars().filter(g -> g == c).count();
    }
    return characterCount + (lastIndex <= 0 ? 0 : prefix[lastIndex - 1]);
  }
}
