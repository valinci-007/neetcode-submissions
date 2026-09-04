class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int n = numbers.size();
        
        int l = 0, r = n - 1;

        while (l < r) {
            int num1 = numbers[l];
            int num2 = numbers[r];
            
            if (num1 + num2 == target) {
                return vector<int> {l + 1, r + 1};
            } else if (num1 + num2 > target) {
                r--;
            } else {
                l++;
            }
        }

        return vector<int> {-1, -1};
    }
};
