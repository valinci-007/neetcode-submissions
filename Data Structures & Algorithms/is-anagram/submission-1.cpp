class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;

        sort(s.begin(), s.end());
        sort(t.begin(), t.end());

        int p_s = 0;
        int p_t = 0;

        while(p_s < s.size() && s[p_s] == t[p_t]){
            p_s++;
            p_t++;
        }

        return p_s == s.size();
    }
};
