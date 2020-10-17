class restoreString {
    public String restoreString(String s, int[] indices) {
        String result = "";
        char[] letters = new char[indices.length];
        for (int i =0; i < s.length(); i++) {
            letters[indices[i]] = s.charAt(i);
        }
        for (int i =0; i < indices.length; i++) {
            result += letters[i];
        }
        return result;
    }
}