class Solution {
    public int jump(int[] nums) {
        int currMaxJump = 0, endJump = 0, totJump=0;
        for(int i=0;i<nums.length-1;i++){
            currMaxJump = Math.max(currMaxJump, i+nums[i]);
            if(i==endJump){
                endJump=currMaxJump;
                totJump++;
            }
        }
        return totJump;
    }
}