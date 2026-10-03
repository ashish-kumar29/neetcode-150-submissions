class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.toLowerCase();
        int i=0, j=temp.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(temp.charAt(i))) i++;
            while(j>i && !Character.isLetterOrDigit(temp.charAt(j))) j--;
            if(j<=i) break;
            if(temp.charAt(i)!=temp.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}