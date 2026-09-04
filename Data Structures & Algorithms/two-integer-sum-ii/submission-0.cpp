class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int n = numbers.size();
        unordered_map<int, int> mp;

        for (int i = 0; i < n; i++) {
            mp[numbers[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;

            if (mp.find(num2) != mp.end() && mp[num2] != i) {
                return vector<int> {i + 1, mp[num2] + 1};
            }
        }

        return vector<int> {-1, -1};
    }
};
