class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int high = nums.length-1;
        int low = 0;

        return MakeBST(nums, low, high);
    }

    static TreeNode MakeBST(int[] nums, int low, int high) {

        if(low > high)
            return null;
        int mid = (low + high) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = MakeBST(nums, low, mid-1);
        node.right = MakeBST(nums, mid+1, high);

        return node;
    }
}
