class Solution {
    int[][] memo;
    private boolean solve(int i, int j, String s1, String s2, String s3){
        if(i==s1.length() && j==s2.length()) {
            return true;
        }

        if(memo[i][j] != -1){
            return memo[i][j] == 1;
        }

        boolean s1Matched = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            s1Matched = solve(i+1, j, s1, s2, s3);
        }
        boolean s2Matched = false;
        if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            s2Matched = solve(i, j+1, s1, s2, s3);
        }
        memo[i][j] = s1Matched || s2Matched ? 1 : 0;
        return s1Matched || s2Matched;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.memo = new int[s1.length()+1][s2.length()+1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s1, s2, s3);
    }
}
