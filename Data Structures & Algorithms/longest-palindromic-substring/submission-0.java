class Solution {
    public String longestPalindrome(String s) {
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // suppose i, is the center of the palindrome
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);

            int len = Math.max(odd, even);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1)/2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expand (String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}
