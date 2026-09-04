class Solution {
    private void generate (int i, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr)); // copy the snapshot
            return;
        }

        // don't take the elenment nums[i]
        generate (i + 1, nums, curr, ans);
        curr.add (nums[i]);
        generate (i + 1, nums, curr, ans);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generate (0, nums, curr, ans);

        return ans;
    }
}
