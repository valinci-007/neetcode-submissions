class Solution {
    int[][] memo;
    private int solve(int i, int j, int[] nums){
        if(j - i < 2){
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxCoins = Integer.MIN_VALUE;
        for(int k=i+1; k<j; k++){
            int leftCoins = solve(i, k, nums);
            int rightCoins = solve(k, j, nums);
            maxCoins = Math.max(maxCoins, leftCoins + rightCoins + nums[i]*nums[k]*nums[j]);
        }

        return memo[i][j] = maxCoins;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[nums.length+2];
        padded[0] = 1;
        padded[nums.length+1] = 1;

        this.memo = new int[n+2][n+2];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }

        for(int i=1; i<=n; i++){
            padded[i] = nums[i-1];
        }

        return solve(0, n+1, padded);
    }
}
