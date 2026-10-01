class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> freq = new HashSet<>();
    //     int left = 0, right=0, n=s.length();
    //     int ans = 0;
    //     while(right<n){
    //         while(right<n && freq.contains(s.charAt(right))){
    //             freq.remove(s.charAt(left++));
    //         }
    //         freq.add(s.charAt(right));
    //         ans = Math.max(ans, right-left+1);
    //         right++;
    //     }
    //     return ans;
    // }


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPos = new HashMap<>();
        int left = 0, right=0, n=s.length();
        int ans = 0;
        while(right<n){
            char c = s.charAt(right);
            if(charPos.containsKey(c)){
                int idx = charPos.get(c);
                if(left<=idx) left = idx+1;   // here if condition is must as for test case "abba" when right index reach to 3 then idx will store 0 , so left will become 1 but it was 2 earlier. So, if the "if" condition not present, answer will come as 3-1+1 = 3 which is wrong
            }
            charPos.put(c, right);
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}

// a b b a
// l=2, r=3
// ans=2
// a=0
// b=2
