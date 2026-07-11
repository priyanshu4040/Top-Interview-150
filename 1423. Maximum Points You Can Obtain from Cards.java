class Solution {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // If we take every card,
        // simply return the total sum.
        if (k == n) {

            int total = 0;

            for (int num : cardPoints)
                total += num;

            return total;
        }

        // Size of the subarray that will remain unpicked.
        int windowSize = n - k;

        // Total sum of all cards.
        int totalSum = 0;

        for (int num : cardPoints)
            totalSum += num;

        // Current window sum.
        int windowSum = 0;

        // Build the first window.
        for (int i = 0; i < windowSize; i++)
            windowSum += cardPoints[i];

        // Initially, first window is the minimum.
        int minWindowSum = windowSum;

        // Slide the window.
        for (int right = windowSize; right < n; right++) {

            // Add new element entering the window.
            windowSum += cardPoints[right];

            // Remove leftmost element leaving the window.
            windowSum -= cardPoints[right - windowSize];

            // Update minimum window sum.
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        // Maximum score =
        // Total sum - Minimum unpicked window sum.
        return totalSum - minWindowSum;
    }
}
