class Solution {
    public boolean isPalindrome(String s) {
        String cleaned="";

        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                cleaned+=Character.toLowerCase(ch);

            }

        }
        
        String rev=new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(rev);

    }
}