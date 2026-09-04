class Solution {
public:
    bool isGood (int rate, vector<int>& piles, int h) {
        int time = 0;

        for (int &p : piles) {
            time += (p % rate == 0) ? p / rate : p / rate + 1;
        }

        return time <= h;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 1;
        int high = *max_element (piles.begin(), piles.end());
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isGood (mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
};
