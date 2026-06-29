class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '(' && count == 0)
                count++;
            else if(ch == '(' && count != 0) {
                count++;
                sb.append(ch);
            }
            else {
                count--;
                if(count != 0)
                    sb.append(ch);
            }

        }

        return sb.toString();
        
    }
}
