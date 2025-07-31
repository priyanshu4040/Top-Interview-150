class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int count = 1;
        int len = nums.length;

        for(int j = 1;j < len;j++) {
            
            if(nums[j] == nums[j-1] && count < 2) {
                nums[i] = nums[j];
                count++;
                i++;
            }
            else if(nums[j] == nums[j-1] && count>= 2){
                count++;
            }
            else {
                nums[i++] = nums[j];
                count = 1;
            }
        }

        // for(int j = 0;j < len-1;j++) {
        //     if(nums[j] == nums[j+1] && count <= 2) {
        //         nums[i] = nums[j];
        //         count++;
        //         i++;
        //     }
        //     else if(nums[j] == nums[j+1] && count >=3) {
        //         continue;
        //     }
        //     else {
        //         nums[i] = nums[j];
        //         i++;
        //         count = 1;
        //     }
        // }
        return i;
    }
}
