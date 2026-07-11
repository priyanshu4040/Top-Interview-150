class Solution {

    public int numberOfSubstrings(String s) {

        // Frequency array to store the count of
        // 'a', 'b', and 'c' inside the current window.
        //
        // freq[0] -> count of 'a'
        // freq[1] -> count of 'b'
        // freq[2] -> count of 'c'
        int[] freq = new int[3];

        // Left pointer of the sliding window
        int left = 0;

        // Stores the total number of valid substrings
        int ans = 0;

        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {

            // Include the current character in the window
            //
            // 'a' - 'a' = 0
            // 'b' - 'a' = 1
            // 'c' - 'a' = 2
            freq[s.charAt(right) - 'a']++;

            /*
             * If the current window contains at least one
             * 'a', one 'b', and one 'c',
             * then try to shrink the window from the left.
             *
             * We keep shrinking until removing one more
             * character makes the window invalid.
             *
             * This helps us find the smallest invalid window.
             */
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // Remove the leftmost character from the window
                freq[s.charAt(left) - 'a']--;

                // Move left pointer forward
                left++;
            }

            /*
             * IMPORTANT OBSERVATION
             * ---------------------
             *
             * After the above while-loop ends,
             * the current window NO LONGER contains
             * all three characters.
             *
             * Suppose left becomes 3.
             *
             * That means every substring ending at 'right'
             * and starting from indices:
             *
             *      0
             *      1
             *      2
             *
             * was valid.
             *
             * Total valid starting positions = left.
             *
             * Therefore add 'left' to the answer.
             */
            ans += left;
        }

        // Return the total number of valid substrings
        return ans;
    }
}
