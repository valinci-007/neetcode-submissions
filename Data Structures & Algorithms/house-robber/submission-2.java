class Solution {
    private int dp (int i, int[] nums, int[] memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int rob = nums[i] + dp(i + 2, nums, memo);
        int dontRob = 0 + dp(i+1, nums, memo);

        return memo[i] = Math.max(rob, dontRob);
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return dp(0, nums, memo);
    }
}
