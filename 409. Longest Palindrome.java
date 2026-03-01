import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for(char ch : s.toCharArray()){
            count[ch]++;
        }
        //for(int i = 0; i < s.length(); i++) {
        //    count[s.charAt(i)]++;
        }
        int res = 0;

        for(int i = 0; i < 128; i++) {
            int val = count[i];
            //If the value is odd, it will consider even
            //E.g : if value is 7, it will consider 6.
            res = res + (val/2)*2;
            if(res % 2 == 0 && val % 2 == 1)
                res++;
        }

        return res;
    }
}
