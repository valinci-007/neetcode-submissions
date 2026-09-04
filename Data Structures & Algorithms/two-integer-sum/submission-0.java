class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            hash.put(nums[i], i);
        }

        for(int i=0; i<n; i++){
            int num1 = nums[i];
            int num2 = target - num1;

            if(hash.containsKey(num2) && hash.get(num2) != i){
                return new int[]{i, hash.get(num2)};
            }
        }

        return new int[]{-1, -1};
    }
}
