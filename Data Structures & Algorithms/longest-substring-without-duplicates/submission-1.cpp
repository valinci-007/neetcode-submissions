class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;
        unordered_set<char> st;

        int l = 0;
        for (int r = 0; r < s.size(); r++) {
            char c = s[r];
            while (st.count (c) != 0){
                st.erase (s[l]);
                l++;
            }

            st.insert (c);

            ans = max (ans, r - l + 1);
        }

        return ans;
    }
};
