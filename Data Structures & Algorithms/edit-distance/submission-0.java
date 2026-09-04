class Solution {
    int[][] memo;
    
    private int solve(int i, int j, String s, String t){
        if(i==s.length()){
            return t.length() - j;
        }
        if(j==t.length()){
            return s.length() - i;
        }

        if(memo[i][j] != -1) return memo[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return memo[i][j] = 0 + solve(i+1, j+1, s, t);
        } else {
            int insert = 1 + solve(i,j+1,s,t);
            int delete = 1 + solve(i+1, j, s, t);
            int replace = 1 + solve(i+1,j+1,s,t);

            return memo[i][j] = Math.min(Math.min(insert, delete), replace);
        }
    }

    public int minDistance(String word1, String word2) {
        this.memo = new int[word1.length()][word2.length()];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, word1, word2);
    }
}
