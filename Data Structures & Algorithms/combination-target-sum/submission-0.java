class Solution {
    private List<List<Integer>> ans;
    private void getComb(List<Integer> comb, int st, int[] candidates, int target){
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i=st;i<candidates.length;i++){
            if(candidates[i]<=target){
                comb.add(candidates[i]);
                getComb(comb,i,candidates, target-candidates[i]);
                comb.remove(comb.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        getComb(new ArrayList<>(), 0, candidates, target);
        return ans;
    }
}