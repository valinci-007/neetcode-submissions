class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.size() + nums2.size();
        int leftSize = (n + 1) / 2;

        int low = 0;
        int high = nums1.size();

        while (low <= high) {
            int mid1 = low + (high - low) / 2;   // Elements taken from nums1
            int mid2 = leftSize - mid1;          // Elements taken from nums2

            int arr1_left = (mid1 == 0) ? INT_MIN : nums1[mid1 - 1];
            int arr1_right = (mid1 == nums1.size()) ? INT_MAX : nums1[mid1];

            int arr2_left = (mid2 == 0) ? INT_MIN : nums2[mid2 - 1];
            int arr2_right = (mid2 == nums2.size()) ? INT_MAX : nums2[mid2];

            if (arr1_left <= arr2_right && arr2_left <= arr1_right) {
                if (n % 2 == 0) {
                    return (max(arr1_left, arr2_left) + min(arr1_right, arr2_right)) / 2.0;
                } else {
                    return max(arr1_left, arr2_left);
                }
            }
            else if (arr1_left > arr2_right) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
};