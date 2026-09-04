class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        sort (nums.begin(), nums.end());
        vector<vector<int>> ans;

        for (int k = n - 1; k >= 2; k--) {
            if (k != n - 1) {
                while (k >= 2 && nums[k] == nums[k + 1]) {
                    k--;
                }
            }

            int target = 0 - nums[k];
            int i = 0, j = k - 1;
            while (i < j) {
                int num1 = nums[i];
                int num2 = nums[j];

                if (num1 + num2 == target) {
                    ans.push_back ({nums[i], nums[j], nums[k]});
                    while (i < j && nums[i] == num1) {
                        i++;
                    }
                    while (j > i && nums[j] == num2) {
                        j--;
                    }
                } else if (num1 + num2 > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return ans;
    }
};
