class Solution {

    // Stores the maximum BST sum found so far.
    int maxSum = 0;

    /**
     * Information returned by every subtree.
     */
    class NodeInfo {

        // Whether this subtree is a BST.
        boolean isBST;

        // Minimum value inside this subtree.
        int min;

        // Maximum value inside this subtree.
        int max;

        // Sum of all nodes in this subtree.
        int sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    /**
     * Postorder DFS.
     *
     * Returns information about the current subtree.
     */
    private NodeInfo dfs(TreeNode root) {

        // -----------------------------
        // Base Case
        // -----------------------------
        // Empty tree is a valid BST.
        if (root == null) {

            return new NodeInfo(
                    true,
                    Integer.MAX_VALUE,   // minimum
                    Integer.MIN_VALUE,   // maximum
                    0                    // sum
            );
        }

        // -----------------------------------
        // Process left subtree first
        // -----------------------------------
        NodeInfo left = dfs(root.left);

        // -----------------------------------
        // Process right subtree
        // -----------------------------------
        NodeInfo right = dfs(root.right);

        // -------------------------------------------------
        // Check whether current subtree is a BST.
        // -------------------------------------------------
        if (left.isBST &&
            right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            // Current subtree forms a BST.

            int currentSum = left.sum + right.sum + root.val;

            // Update global maximum.
            maxSum = Math.max(maxSum, currentSum);

            // Compute minimum value of this subtree.
            int currentMin = Math.min(root.val, left.min);

            // Compute maximum value of this subtree.
            int currentMax = Math.max(root.val, right.max);

            return new NodeInfo(
                    true,
                    currentMin,
                    currentMax,
                    currentSum
            );
        }

        // -------------------------------------------------
        // Current subtree is NOT a BST.
        //
        // Parent should never consider this subtree
        // while forming a BST.
        // -------------------------------------------------
        return new NodeInfo(
                false,
                0,
                0,
                0
        );
    }
}
