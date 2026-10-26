class Solution {
    private List<List<Integer>> ans;
    private void backTrack(int[] nums, List<Integer> lst, int i){
        if(i==nums.length) { 
            ans.add(new ArrayList<>(lst));
            return;
        }
        // Not taken
        backTrack(nums, lst, i+1);
        // taken
        lst.add(nums[i]);
        backTrack(nums, lst, i+1);
        lst.remove(lst.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), 0);
        return ans;
    }
}
// 1 2 3
// [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]