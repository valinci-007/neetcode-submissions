class Solution {
    int N, M;
    int paths(int r, int c, int[][] dp){
        if(r<0||c<0||r>=M||c>=N){
            return 0;
        }
        if(r==M-1 && c==N-1){
            return 1;
        }

        if(dp[r][c] != -1) return dp[r][c];

        return dp[r][c] = paths(r+1,c,dp) + paths(r,c+1,dp);
    }

    public int uniquePaths(int m, int n) {
        this.N = n;
        this.M = m;
        int[][] dp = new int[M][N];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        return paths(0,0,dp);
    }
}
