class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> hash = new HashSet<>();

        for (int num : nums) {
            hash.add(num);
        }

        int ans = 1;
        for(int i=0; i<nums.length; i++){
            if(!hash.contains(nums[i]-1)){
                int x = nums[i];
                int len = 1;
                while(hash.contains(x+1)){
                    len++;
                    x++;
                }
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
