class Solution {
public:
    string minWindow(string s, string t) {
        if (t.size() > s.size()) {
            return "";
        }

        unordered_map<char, int> target;
        unordered_map<char, int> window;

        for (int i = 0; i < t.size(); i++) {
            target[t[i]]++;
        }

        for (int i = 0; i < t.size(); i++) {
            window[s[i]]++;
        }

        int have = 0;
        for (auto &p: target) {
            if (window.find (p.first) != window.end() && window[p.first] >= p.second) {
                have++;
            }
        }

        int len = INT_MAX;
        int start = 0;

        int left = 0;

        while (have == target.size()) {
            if (t.size() < len) {
                len = t.size();
                start = left;
            }

            if (target.count(s[left]) &&
                window[s[left]] == target[s[left]]) {
                have--;
            }
            
            window[s[left]]--;
            left++;
        }

        for (int right = t.size(); right < s.size(); right++) {
            window[s[right]]++;

            if (target.find(s[right]) != target.end() && window[s[right]] == target[s[right]]) {
                have++;
            }

            while (have == target.size()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    start = left;
                }

                if (target.find (s[left]) != target.end()) {
                    if (window[s[left]] == target[s[left]]) {
                        have--;
                    }
                }
                
                window[s[left]]--;
                left++;
            }
        }

        return len == INT_MAX ? "" : s.substr(start, len);
    }
};