class Solution {
    int[][] memo;

    private boolean solve(int i, int target, int[] nums) {

        if (target == 0)
            return true;

        if (i == nums.length || target < 0)
            return false;

        if (memo[i][target] != -1)
            return memo[i][target] == 1;

        boolean ans =
            solve(i + 1, target - nums[i], nums) ||
            solve(i + 1, target, nums);

        memo[i][target] = ans ? 1 : 0;

        return ans;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum%2 != 0) return false;
        this.memo = new int[nums.length][sum/2 + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, sum/2, nums);
    }
}
