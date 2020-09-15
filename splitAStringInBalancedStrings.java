class Solution {
    public int balancedStringSplit(String s) {
        int balancedStrings = 0;
        int counter = 0;
        char[] characters = s.toCharArray();
        for (char c : characters) {
            if (c == 'L') {
                counter++;
                
            } else {
                counter--;
            }
            if (counter == 0) {
                    balancedStrings++;
                }
        }

        return balancedStrings;
    }
}