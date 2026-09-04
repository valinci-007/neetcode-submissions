class Solution {
    int N, M;

    public int uniquePaths(int m, int n) {
        this.N = n;
        this.M = m;
        int[][] dp = new int[M][N];
        for (int[] row : dp){
            Arrays.fill(row, 0);
        }
        dp[M-1][N-1] = 1;

        for(int r=M-1; r>=0; r--){
            for(int c=N-1; c>=0; c--){
                if(r+1 < M){
                    dp[r][c] += dp[r+1][c];
                }
                if(c+1<N){
                    dp[r][c] += dp[r][c+1];
                }
            }
        }

        return dp[0][0];
    }
}
