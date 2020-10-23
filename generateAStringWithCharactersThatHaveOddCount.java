public class generateAStringWithCharactersThatHaveOddCount {
    public String generateTheString(int n) {
        String result = "";
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                result += "a";
            }
        } else {
            for (int i = 0; i < n-1; i++) {
                result += "a";                
            } result += "b";

        }
        return result;
    }
    public String generateTheStringBuilder(int n) {
        StringBuilder oddCountString = new StringBuilder();
        if(n % 2 == 0) {
            oddCountString.append("z");
            n--;
        }
        String repeater = "a";
        oddCountString.append(repeater.repeat(n));
        return oddCountString.toString();
    }
}
