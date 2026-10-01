class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left=0, right=0, mxCount=0;
        int ans=0;
        while(right<s.length()){
            freq[s.charAt(right)-'A']++;
            mxCount = Math.max(freq[s.charAt(right)-'A'], mxCount);
            while((right-left+1)-mxCount>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}
// AABABBBA
// A-1
// B-2
// ans=4