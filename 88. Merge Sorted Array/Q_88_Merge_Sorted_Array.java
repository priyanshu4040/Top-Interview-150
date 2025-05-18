
public class Q_88_Merge_Sorted_Array {

  static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
  }

  public static void main(String[] args) {

    int[] arr1 = { 1, 3, 5, 7, 0, 0, 0 };
    int[] arr2 = { 2, 4, 6 };

    int n = arr2.length;
    int m = arr1.length - n;

    merge(arr1, m, arr2, n);

    System.out.print("[");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(+arr1[i] + ",");
    }
    System.out.println("]");
  }
}