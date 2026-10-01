// Requirement: choose a window with total size = freq (for max freq) + k
// windowSize-maxFreq<=k
// XYYX
// k=2
// X-2
// Y-2
// i=0
// j=3
// mxFreq=2
// ans=3

// AAABABB
// k=1
// A-1
// B-3
// i=2
// j=6
// mxFreq=4
// ans=5
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        // for(char c: s.toCharArray()){
        //     freq[c-'A']++;
        // }
        int i=0, j=0, ans = 0, maxFreq=0;
        while(j<s.length()){
            freq[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j)-'A']);
            if(j-i+1-maxFreq>k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(j-i+1, ans);
            j++;
        }
        return ans;
    }
}
