class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        for(int v:nums) st.add(v);
        for(int val:st){
            if(!st.contains(val-1)){
                int currLen = 1;
                while(st.contains(val+currLen)) currLen++;
                ans = Math.max(currLen, ans);
            }
        }
        return ans;
    }
}