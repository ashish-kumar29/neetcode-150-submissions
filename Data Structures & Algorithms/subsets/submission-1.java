class Solution {
    private List<List<Integer>> ans;
    private void backTrack(int[] nums, List<Integer> lst, int i){
        ans.add(new ArrayList<>(lst));
        for(int i1=i;i1<nums.length;i1++){
            lst.add(nums[i1]);
            backTrack(nums, lst, i1+1);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), 0);
        return ans;
    }
}
// 1 2 3
// [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]