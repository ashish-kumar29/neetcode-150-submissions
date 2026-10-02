class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            ans[i] = ans[i+1]*nums[i+1];
        }
        for(int i=0, pref=1;i<nums.length;i++){
            ans[i]= pref*ans[i];
            pref*=nums[i];
        }
        return ans;
    }
}
