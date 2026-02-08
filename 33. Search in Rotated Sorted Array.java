class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = l + (h - l)/2;

            if(nums[mid] == target)
                return mid;
      //Identify where mid lies(higher values secotion or lower value section)
            if(nums[l] <= nums[mid]){
            //checking whether key lies between low and mid
                if(target >= nums[l] && target < nums[mid])
                    h = mid - 1;
                else //when key not lies between low and mid
                    l = mid + 1;
            }
            else{
                //When key is smaller than arr[low]
                if(target <= nums[h] && target > nums[mid])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }

        return -1;
    }
}
