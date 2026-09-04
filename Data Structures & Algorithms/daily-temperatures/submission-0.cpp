class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();

        stack <int> st;
        st.push (n - 1);
        vector<int> nge (n);
        nge [n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.empty() && temperatures[st.top()] <= temperatures[i]) {
                st.pop();
            }

            if (st.empty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.top();
            }

            st.push (i);
        }

        vector<int> res(n);
        for (int i = 0; i < n; i++) {
            if (nge[i] == -1) {
                res[i] = 0;
            } else {
                res[i] = (nge[i] - i);
            }
        }

        return res;
    }
};
