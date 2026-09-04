class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int n = speed.size();
        vector<pair<int, int>> arr (n);

        for (int i = 0; i < n; i++) {
            arr[i] = {position[i], speed[i]};
        }

        sort (arr.begin(), arr.end());

        stack<double> st;

        for (int i = n - 1; i >= 0; i--) {
            double pos = arr[i].first;
            double carspeed = arr[i].second;

            double time = (target - pos) / carspeed;

            if (st.empty()) {
                st.push (time);
                continue;
            }

            if (st.top() < time) {
                st.push (time);
            }
        }

        return st.size();
    }
};
