class Solution {
public:
    bool isPalindrome(string s) {
        string ns = "";

        for (char c : s) {
            if (isalnum(c)) {
                ns += tolower(c);
            }
        }
        s = ns;

        int l = 0, r = s.size() - 1;

        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l ++;
            r --;
        }

        return true;
    }
};
