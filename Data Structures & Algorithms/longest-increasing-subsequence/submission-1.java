class Solution {
    // f (i, prev_ind) -> longest inc subs starting from i, if the prev ele is prev_ind
    private int f(int ind, int prev_ind, int[] nums, int[][] cache) {
        if (ind == nums.length) {
            return 0;
        }

        if (cache[ind][prev_ind+1] != -1) {
            return cache[ind][prev_ind+1];
        }

        int dontTake = f(ind + 1, prev_ind, nums, cache);

        int take = 0;
        if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            take = 1 + f(ind+1, ind, nums, cache);
        }

        return cache[ind][prev_ind+1] = Math.max(take, dontTake);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        // f (i, prev_ind)
        int[][] cache = new int[nums.length+1][nums.length+1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return f (0, -1, nums, cache);
    }
}
