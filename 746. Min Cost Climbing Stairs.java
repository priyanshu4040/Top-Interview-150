//Starting from 0th position
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

//Starting from Nth position
class Solution {

    static int solve(int[] cost,int[] dp, int n) {
        if(n == 0)
            return cost[0];
        else if(n == 1)
            return cost[1];

        if(dp[n] != -1)
            return dp[n];

         dp[n] = Math.min(solve(cost,dp, n-1), solve(cost,dp, n-2))+cost[n];
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = Math.min(solve(cost,dp,n-1), solve(cost,dp,n-2));
        return ans;
    }
}

//Bottom-Up approach(Tabulation)
class Solution {

    static int solve(int[] cost, int n) {
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2])+ cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int ans = solve(cost, n);
        return ans;
    }
}

//Space Optimization
    class Solution {

        static int solve(int[] cost, int n) {
            int prev1 = cost[0];
            int prev2 = cost[1];
            int curr = 0;

            for(int i = 2; i < n; i++) {
                curr = Math.min(prev1,prev2)+cost[i];
                prev1 = prev2;
                prev2 = curr;
            }
            return Math.min(prev1, prev2);
        }
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            
            int ans = solve(cost, n);
            return ans;
        }
    }
