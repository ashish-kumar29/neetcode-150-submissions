class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashSet<Integer> st = new HashSet<>();
        for(int val:nums) st.add(val);
        for(int val:st){
            if(!st.contains(val-1)){
                int count=1;
                while(st.contains(val+count)) count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}