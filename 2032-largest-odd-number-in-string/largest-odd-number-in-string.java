class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        
        // Scan the string from right to left (end to start)
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            
            // Check if the digit itself is odd
            // (c - '0' converts the character digit to its actual integer value)
            if ((c - '0') % 2 != 0) {
                // If it's odd, return the substring from index 0 up to this digit
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found in the entire string, return an empty string
        return "";
    }
}
