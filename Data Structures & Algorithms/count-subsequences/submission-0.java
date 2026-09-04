class Solution {
    int[][] memo;
    private int solve(int i, int j, String s, String t){
        if(j>=t.length()) return 1;
        if(i>=s.length()) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        int count = 0;
        if(s.charAt(i) == t.charAt(j)){
            count = solve(i+1, j, s, t) + solve(i+1, j+1, s, t);
        } else {
            count = solve(i+1, j, s, t);
        }
        return memo[i][j] = count;
    }

    public int numDistinct(String s, String t) {
        this.memo = new int[s.length()][t.length()];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s, t);
    }
}
