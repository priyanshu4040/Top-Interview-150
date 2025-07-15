
class Q27_Remove_Element {
  public int removeElement(int[] nums, int val) {
    // Step 1: Initialize a new index i to keep track of the new array length.
    int i = 0;

    // Step 2: Iterate through the array using another index j.
    for (int j = 0; j < nums.length; j++) {
      // Step 3: If the current element is not equal to the value to remove, move it
      // to the position i.
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    // Step 4: Return i, which is the new length of the array.
    return i;
  }
}