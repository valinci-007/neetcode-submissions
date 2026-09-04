class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {

        int n = nums.size();

        // Stores indices.
        // Values corresponding to these indices are kept
        // in decreasing order.
        deque<int> dq;

        vector<int> ans;

        int l = 0;

        // Expand the window one element at a time.
        for (int r = 0; r < n; r++) {

            // --------------------------------------------------
            // Step 1:
            // Remove all smaller elements from the back.
            // They can never become the maximum while nums[r]
            // exists in the window.
            // --------------------------------------------------
            while (!dq.empty() && nums[dq.back()] < nums[r]) {
                dq.pop_back();
            }

            // --------------------------------------------------
            // Step 2:
            // Insert the current index.
            // --------------------------------------------------
            dq.push_back(r);

            // --------------------------------------------------
            // Step 3:
            // Remove indices that are outside the window.
            // Current window = [l ... r]
            // --------------------------------------------------
            if (dq.front() < l) {
                dq.pop_front();
            }

            // --------------------------------------------------
            // Step 4:
            // Once the window size becomes k,
            // the front of the deque is the maximum.
            // --------------------------------------------------
            if (r - l + 1 == k) {

                ans.push_back(nums[dq.front()]);

                // Slide the window.
                l++;
            }
        }

        return ans;
    }
};