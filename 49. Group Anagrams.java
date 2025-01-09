//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to store groups of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Convert the string to a character array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            
            // Use the sorted string as a key
            String key = new String(chars);
            
            // If the key doesn't exist in the map, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            // Add the original string to the corresponding group
            map.get(key).add(str);
        }
        
        // Return the values of the map as a list of lists
        return new ArrayList<>(map.values());
    }
}
