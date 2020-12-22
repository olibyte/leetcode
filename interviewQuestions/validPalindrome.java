package interviewQuestions;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        //empty and 1 character strings are palindromes
        if (s.length() == 0 || s.length() == 1)
            return true;
        //convert to lower case
        s = s.toLowerCase();
        int header = 0;
        int trailer = s.length() - 1;
        
        while(header <= trailer) {
            //character is not alphanumeric, so look at next
            if(!Character.isLetterOrDigit(s.charAt(header))) {
                header++;
                continue;
            } else if(!Character.isLetterOrDigit(s.charAt(trailer))) {
                trailer--;
                continue;
            }
            //if the candidates do not match, cannot be a palindrome
            else if(s.charAt(header) != s.charAt(trailer)) {
                return false;
            }
            
            header++;
            trailer--;
        }
        
        return true;
    }
}