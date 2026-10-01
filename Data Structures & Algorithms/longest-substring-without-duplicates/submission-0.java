class Solution {
    // "zxyyxyz"
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        Set<Character> visChar = new HashSet<>();
        int i=0,j=0;
        while(j<s.length()){
            while(visChar.contains(s.charAt(j))){
                visChar.remove(s.charAt(i++));
            }
            visChar.add(s.charAt(j));
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
