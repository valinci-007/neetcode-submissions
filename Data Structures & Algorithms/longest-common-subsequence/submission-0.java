class Solution {
    int[][] memo;
    private int solve(int i, int j, String text1, String text2){
        if(i>=text1.length() || j>=text2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            return memo[i][j]= 1 + solve(i+1, j+1, text1, text2);
        } else {
            return memo[i][j]= Math.max(solve(i, j+1, text1, text2), solve(i+1, j, text1, text2));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        this.memo = new int[text1.length()][text2.length()];
        for(int[] row:memo){
            Arrays.fill(row, -1);
        }
        return solve(0,0, text1, text2);
    }
}
