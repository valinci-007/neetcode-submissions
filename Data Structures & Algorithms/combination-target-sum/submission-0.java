class Solution {
    private void backtrack (int i, int[] nums, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add (new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i == nums.length) {
            return;
        }

        curr.add (nums[i]);
        backtrack (i, nums, target - nums[i], curr, ans);
        curr.remove (curr.size() - 1);

        backtrack (i + 1, nums, target, curr, ans);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack (0, nums, target, new ArrayList<>(), ans);

        return ans;
    }
}
