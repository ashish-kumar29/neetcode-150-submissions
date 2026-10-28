class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), 0);
        return ans;
    }
    public void backTrack(int[] nums, List<Integer> subset, int st){
        ans.add(new ArrayList<>(subset));
        for(int i=st;i<nums.length;i++){
            if(i-1>=st && nums[i-1]==nums[i]) continue;
            subset.add(nums[i]);
            backTrack(nums, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
}