class Solution {
    int[][] memo;
    private int solve(int day, int buy, int[] prices){
        if(day>=prices.length) return 0;
        if(memo[day][buy] != -1) return memo[day][buy];
        if(buy==1){
            return memo[day][buy] = Math.max(solve(day+1, 0, prices) - prices[day], solve(day+1, buy, prices));
        }else{
            return memo[day][buy] = Math.max(solve(day+1, 0, prices), prices[day] + solve(day+2, 1, prices));
        }
    }

    public int maxProfit(int[] prices) {
        this.memo = new int[prices.length][2];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices);
    }
}
