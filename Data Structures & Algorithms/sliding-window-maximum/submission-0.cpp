class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> res;

        for (int i = 0; i <= nums.size() - k; i++) {
            int maxVal = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                maxVal = max (nums[j], maxVal);
            }

            res.push_back (maxVal);
        }

        return res;
    }
};
