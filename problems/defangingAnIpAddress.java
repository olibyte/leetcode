class defangIPaddr {
    public String defangIPaddr(String address) {
        char[] ipCharacters = address.toCharArray();
        StringBuffer defangedAddress = new StringBuffer();
        for (int i = 0; i < ipCharacters.length; i++) {
            if (ipCharacters[i] == '.') {
                defangedAddress.append("[.]");
            } else {
                defangedAddress.append(ipCharacters[i]);
            }
        }
        return defangedAddress.toString();

        // 100% faster
        // return address.replace(".", "[.]");
    }
}