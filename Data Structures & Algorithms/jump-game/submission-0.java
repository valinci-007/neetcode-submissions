class Solution {
    private boolean solve(int i, int[] nums){
        if(i >= nums.length-1) return true;
        for(int j = 1; j <= nums[i]; j++){
            if(solve(i + j, nums)) return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        return solve(0, nums);
    }
}
