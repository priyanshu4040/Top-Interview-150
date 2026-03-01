class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = merge(nums1,m,nums2,n);
        for(int i : arr)
            System.out.println(i);
        int len = arr.length;

        if(len % 2 != 0)
            return (double)arr[len/2];
        else
            return (double)(arr[len/2] + arr[(len/2)-1])/2;
    }
    
    static int[] merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    
    int[] arr = new int[m+n];
    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        arr[k--] = nums1[i--];
      } else {
        arr[k--] = nums2[j--];
      }
    }
    while(i >= 0) {
        arr[k--] = nums1[i--];
      }

    return arr;
  }
}
