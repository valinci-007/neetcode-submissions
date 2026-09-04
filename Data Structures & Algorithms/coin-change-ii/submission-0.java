class Solution {
    int[][] memo;
    private int solve(int i, int target, int[] coins){
        if(target==0){
            return 1;
        }
        if(i==coins.length-1){
            return target%coins[coins.length-1]==0?1:0;
        }

        if(memo[i][target] != -1) return memo[i][target];

        int takeAndStay = 0;
        if(coins[i] <= target){
            takeAndStay = solve(i, target-coins[i], coins);
        }
        int dontTakeAndGoToNextCoin = solve(i+1, target, coins);

        return memo[i][target] = takeAndStay + dontTakeAndGoToNextCoin;
    }

    public int change(int amount, int[] coins) {
        this.memo = new int[coins.length][amount+1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, amount, coins);
    }
}
