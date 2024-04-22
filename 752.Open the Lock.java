//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
//The lock initially starts at '0000', a string representing the state of the 4 wheels.
//You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
//Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

class Solution {

    private  Set<String> visited  = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0) return -1;

        for(String deadend : deadends){
            visited.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                String currentLock = queue.poll();
                if (visited.contains(currentLock)) continue;
                if (currentLock.equals(target)) return level;

                for (String nextLock : getNextStates(currentLock)) {
                    if (!visited.contains(nextLock)) queue.offer(nextLock);
                }
                visited.add(currentLock);
            }
            level++;
        }

        return -1;
    }

    private Set<String> getNextStates(String lock) {
        Set<String> newLocks = new HashSet<>();
        char[] lockChar = lock.toCharArray();
        for (int i = 0; i < 4; i++) {

            char c = lockChar[i];
            // moving clockwise
            lockChar[i] = c == '9' ? '0' : (char) (c + 1);
            newLocks.add(new String(lockChar));
            // moving anticlockwise
            lockChar[i] = c == '0' ? '9' : (char) (c -1);
            newLocks.add(new String(lockChar));
            lockChar[i] = c;
        }
        return newLocks;
    }
}
