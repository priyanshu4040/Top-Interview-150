class Solution {
    public int strStr(String haystack, String needle) {
        int size = needle.length();
        int n = haystack.length();
        for(int i = 0; i <= n - size; i++) {
            if(haystack.substring(i,i+size).equals(needle))
                return i;
        }

        return -1;
    }
}
