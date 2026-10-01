class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0, j=nums.length-1;
        int sum = nums[i]+nums[j];
        while(sum!=target){
            if(sum>target) j--;
            else i++;
            sum = nums[i]+nums[j];
        }
        return new int[]{i+1,j+1};
    }
}