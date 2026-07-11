import java.util.HashMap;

class Solution {

    // Maps stone position -> its index in the array
    HashMap<Integer, Integer> map = new HashMap<>();

    // Memoization table
    // dp[index][jump] = true/false
    // null means not computed yet
    Boolean[][] dp;

    public boolean canCross(int[] stones) {

        int n = stones.length;

        // Store every stone's position and its index
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        // Maximum possible jump length is at most n
        dp = new Boolean[n][n + 1];

        // Frog starts on stone 0.
        // The first jump must be 1.
        return solve(stones, 0, 0);
    }

    // index = current stone index
    // jump = previous jump length
    boolean solve(int[] stones, int index, int jump) {

        // Reached the last stone
        if (index == stones.length - 1) {
            return true;
        }

        // Already solved
        if (dp[index][jump] != null) {
            return dp[index][jump];
        }

        // Try jump-1, jump, jump+1
        for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {

            // Jump length must be positive
            if (nextJump <= 0) {
                continue;
            }

            // Position where frog will land
            int nextPosition = stones[index] + nextJump;

            // Check if a stone exists at this position
            if (map.containsKey(nextPosition)) {

                int nextIndex = map.get(nextPosition);

                if (solve(stones, nextIndex, nextJump)) {
                    return dp[index][jump] = true;
                }
            }
        }

        return dp[index][jump] = false;
    }
}
