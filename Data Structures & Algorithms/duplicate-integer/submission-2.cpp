class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        map<int, int> mpp;

        for(int i : nums) {
            if(mpp.find(i) != mpp.end()) return true;
            mpp[i] = 1;
        }

        return false;
    }
};