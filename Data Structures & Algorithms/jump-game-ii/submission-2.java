class Solution {
    int[] memo;
    private int solve(int i, int[] nums){
        if(i>=nums.length-1){
            return 0;
        }

        if(memo[i] != -1) return memo[i];

        int ans = Integer.MAX_VALUE;
        for(int j=1; j<=nums[i]; j++){
            if (i + j < nums.length) {
                int jumps = solve(i + j, nums);

                if (jumps != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + jumps);
                }
            }
        }
        return memo[i] = ans;
    }

    public int jump(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solve(0, nums);
    }
}
