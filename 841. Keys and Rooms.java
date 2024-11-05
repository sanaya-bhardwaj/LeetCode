//There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. 
//Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
//When you visit a room, you may find a set of distinct keys in it. 
//Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
//Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

class Solution {
        public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> st = new Stack<>();
        st.add(0);
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        while (!st.isEmpty()) {
            int i = st.pop();
            for (int j : rooms.get(i))
                if (!visited.contains(j)) {
                    st.add(j);
                    visited.add(j);
                    // if (rooms.size() == visited.size()) return true;
                }
        }
        return rooms.size() == visited.size();
    }
}
