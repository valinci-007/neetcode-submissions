class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> MR (n), ML (n);
        
        int currMaxLeft = 0;
        int currMaxRight = n - 1;
        ML [0] = -1;
        MR [n - 1] = -1;
        for (int i = 1; i < n; i++) {
            if (height[currMaxLeft] > height[i]) {
                ML [i] = currMaxLeft;
            } else {
                ML [i] = -1;
                currMaxLeft = i;
            }

            if (height [currMaxRight] > height [n - i - 1]) {
                MR [n - i - 1] = currMaxRight;
            } else {
                MR [n - i - 1] = -1;
                currMaxRight = n - i - 1;
            }
        }

        int water = 0;

        for (int i = 1; i < n - 1; i++) {
            if (MR[i] == -1 || ML[i] == -1) continue;

            water += min (height[ML[i]], height[MR[i]]) - height[i];
        }

        return water;
    }
};
