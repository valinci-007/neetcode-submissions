class Solution {
    private void backtrack (int start, int[] nums, List<List<Integer>> ans) {
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int i : nums) perm.add (i);
            ans.add (perm);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap (nums, start, i);
            backtrack (start + 1, nums, ans);
            swap (nums, start, i); // backtrack
        }
    } 

    private void swap (int[] nums, int a, int b) {
        int t = nums[a];
        nums [a] = nums[b];
        nums [b] = t;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack (0, nums, ans);
        return ans;
    }
}
