class Solution {
    int[][] memo;
    int target;
    int totalSum;
    private int solve(int i, int sum, int[] nums){
        if(i==nums.length){
            return sum == target ? 1 : 0;
        }

        if(memo[i][sum + totalSum] != -1) return memo[i][sum + totalSum];

        return memo[i][sum + totalSum] = solve(i+1, sum + nums[i], nums) + solve(i+1, sum - nums[i], nums);
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        this.totalSum = 0;
        for(int i : nums) this.totalSum += i;
        this.memo = new int[nums.length][2*this.totalSum + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, nums);
    }
}
