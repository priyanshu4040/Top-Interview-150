/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    // The first misplaced node found during inorder traversal.
    TreeNode first = null;

    // The second misplaced node found during inorder traversal.
    TreeNode second = null;

    // Keeps track of the previously visited node during inorder traversal.
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        // Perform inorder traversal to identify the two swapped nodes.
        inorder(root);

        // Swap the values of the two misplaced nodes.
        // This restores the BST without changing its structure.
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    /**
     * Performs inorder traversal.
     *
     * Inorder traversal of a BST should always produce
     * values in strictly increasing order.
     *
     * Whenever prev.val > current.val,
     * we have found a violation.
     */
    private void inorder(TreeNode node) {

        // Base case
        if (node == null)
            return;

        // -------------------------------------------------------
        // Step 1 : Traverse the left subtree
        // -------------------------------------------------------
        inorder(node.left);

        // -------------------------------------------------------
        // Step 2 : Process the current node
        // -------------------------------------------------------

        // If previous node exists and is greater than current node,
        // then BST property is violated.
        if (prev != null && prev.val > node.val) {

            // FIRST VIOLATION
            //
            // Example:
            // Inorder: 1 5 3 4 2 6
            //
            // Violation:
            // 5 > 3
            //
            // first  = 5 (previous node)
            // second = 3 (current node)
            //
            // We set 'first' only once.
            if (first == null) {
                first = prev;
            }

            // SECOND VIOLATION (or updating first violation)
            //
            // Example:
            // 4 > 2
            //
            // Update second = 2
            //
            // For adjacent swapped nodes,
            // this assignment happens only once.
            //
            // For non-adjacent swapped nodes,
            // second gets updated during the second violation.
            second = node;
        }

        // Update previous node before moving right.
        prev = node;

        // -------------------------------------------------------
        // Step 3 : Traverse the right subtree
        // -------------------------------------------------------
        inorder(node.right);
    }
}
