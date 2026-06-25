class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Stores final zigzag traversal
        List<List<Integer>> result = new ArrayList<>();

        // Empty tree case
        if (root == null)
            return result;

        // Queue used for normal BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS from root
        queue.offer(root);

        // Direction flag
        // false = Left to Right
        // true  = Right to Left
        boolean rightToLeft = false;

        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int size = queue.size();

            /*
             * LinkedList is used because:
             * addFirst() -> O(1)
             * addLast()  -> O(1)
             *
             * This helps us avoid reversing later.
             */
            LinkedList<Integer> level = new LinkedList<>();

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                /*
                 * If current level direction is normal,
                 * insert at end.
                 */
                if (!rightToLeft) {
                    level.addLast(current.val);
                }

                /*
                 * If zigzag direction,
                 * insert at front.
                 */
                else {
                    level.addFirst(current.val);
                }

                // Add children for next level

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            // Store current level result
            result.add(level);

            // Flip direction for next level
            rightToLeft = !rightToLeft;
        }

        return result;
    }
}
