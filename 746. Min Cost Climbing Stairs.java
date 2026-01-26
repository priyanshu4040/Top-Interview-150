class Solution {

    static int minCost(int idx, int[] cost, int[] dp) {
        if(idx >= cost.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = Math.min(minCost(idx+1, cost, dp), minCost(idx+2, cost, dp)) + cost[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);

        return Math.min(minCost(0, cost, dp), minCost(1, cost, dp));
    }
}
