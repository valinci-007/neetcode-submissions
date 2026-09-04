class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.size() > s2.size()) {
            return false;
        }

        int s1Freq[26];
        int windowFreq[26];

        for (int i = 0; i < s1.size(); i++) {
            s1Freq[s1[i] - 'a']++;
            windowFreq[s2[i] - 'a']++;
        }

        int matches = 0; // Max req matches for a permutation will be 26

        for (int i = 0; i < 26; i ++) {
            if (s1Freq[i] == windowFreq[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.size(); r < s2.size(); r++) {
            if (matches == 26) {
                return true;
            }

            int rightInd = s2[r] - 'a';
            windowFreq[rightInd]++;

            if (s1Freq[rightInd] == windowFreq[rightInd]) {
                matches++;
            } else if (s1Freq[rightInd] + 1 == windowFreq[rightInd]) {
                matches--;
            }

            int leftInd = s2[l] - 'a';

            windowFreq[leftInd]--;

            if (s1Freq[leftInd] == windowFreq[leftInd]) {
                matches++;
            } else if (windowFreq[leftInd] + 1 == s1Freq[leftInd]) {
                matches--;
            }

            l++;
        }

        return matches == 26;
    }
};
