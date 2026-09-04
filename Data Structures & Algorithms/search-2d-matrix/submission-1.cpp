class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // [0, 1, 2, ... , m * n - 1]
        // index / COLS = row, index % COLS = col

        int ROWS = matrix.size();
        int COLS = matrix[0].size();

        int low = 0;
        int high = ROWS * COLS - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / COLS;
            int col = mid % COLS;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
};
