import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> jewels = new HashSet<>();
        for (char jewel : J.toCharArray()) {
            jewels.add(jewel);
        }
        
        for (char stone : S.toCharArray()) {
            if (jewels.contains(stone)) {
                count++;
            }            
        }

        return count;
    }
}