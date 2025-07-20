class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.isEmpty()) {
            return ""; 
        }

        char[] ch = s.toCharArray();
        int longest = 1;
        int start = 0;

        // Odd length
        for (int i = 0; i < ch.length; i++) {
            int offset = 0;
            while (isValidIndex(ch, i-1-offset) && isValidIndex(ch, i+1+offset)
                   && ch[i-1-offset] == ch[i+1+offset]) { 
                offset++;
            }

            int longestAtI = offset * 2 + 1;
            // if new length is longer than previous longest, you update:
            if (longestAtI > longest) {
                longest = longestAtI;
                start = i - offset;
            }
        }

        // Even length
        for (int i = 0; i < ch.length - 1; i++) {
            int offset = 0;
            while (isValidIndex(ch, i-offset) && isValidIndex(ch, i+1+offset)
                   && ch[i-offset] == ch[i+1+offset]) { 
                offset++;
            }

            int longestAtI = offset * 2;
            // if new length is longer than previous longest, you update:
            if (longestAtI > longest) {
                longest = longestAtI;
                start = i - offset + 1;
            }
        }

        return s.substring(start, start + longest);
    }

    public boolean isValidIndex(char[] a, int i) { 
        return i >= 0 && i < a.length;
    }
}
