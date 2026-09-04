class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
