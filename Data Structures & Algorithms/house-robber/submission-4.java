class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        for (int i = n-1; i>=0; i--) {
            int rob = (i + 2) < n ? nums[i] + dp[i+2] : nums[i];
            int dontRob = (i+1) < n ? dp[i+1] : nums[i];

            dp[i] = Math.max(rob, dontRob);
        }

        return dp[0];
    }
}
