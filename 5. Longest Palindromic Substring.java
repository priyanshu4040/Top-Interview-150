class Solution {

    public String longestPalindrome(String s) {

        // Handle empty string
        if (s == null || s.length() == 0)
            return "";

        // ----------------------------------------------------------
        // Step 1: Transform the string.
        //
        // Example:
        // "abba"
        // becomes
        // "#a#b#b#a#"
        //
        // This converts every palindrome into an odd-length palindrome.
        // ----------------------------------------------------------
        StringBuilder sb = new StringBuilder();

        sb.append('#');

        for (char ch : s.toCharArray()) {
            sb.append(ch);
            sb.append('#');
        }

        String str = sb.toString();

        int n = str.length();

        // P[i] = radius of palindrome centered at i
        int[] P = new int[n];

        // Current center of the rightmost palindrome
        int center = 0;

        // Right boundary of the rightmost palindrome
        int right = 0;

        // Track the longest palindrome
        int maxLen = 0;
        int maxCenter = 0;

        // ----------------------------------------------------------
        // Process every position
        // ----------------------------------------------------------
        for (int i = 0; i < n; i++) {

            // Mirror position of i around current center
            int mirror = 2 * center - i;

            // If i lies inside the current palindrome,
            // use previously computed information.
            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }

            // Expand palindrome centered at i
            while (i - P[i] - 1 >= 0 &&
                   i + P[i] + 1 < n &&
                   str.charAt(i - P[i] - 1) ==
                   str.charAt(i + P[i] + 1)) {

                P[i]++;
            }

            // Update center and right boundary
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }

            // Update longest palindrome found
            if (P[i] > maxLen) {
                maxLen = P[i];
                maxCenter = i;
            }
        }

        // ----------------------------------------------------------
        // Convert back to original string indices.
        //
        // In transformed string:
        // start = maxCenter - maxLen
        //
        // Original index:
        // start = (maxCenter - maxLen) / 2
        // ----------------------------------------------------------
        int start = (maxCenter - maxLen) / 2;

        return s.substring(start, start + maxLen);
    }
}
