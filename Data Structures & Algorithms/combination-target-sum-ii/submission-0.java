class Solution {
    List<List<Integer>> ans;
    public void rec(int[] candidates, int target, int i, List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target<0 || i==candidates.length || candidates[i]>target) return;
        temp.add(candidates[i]);
        rec(candidates,target-candidates[i], i+1, temp);
        temp.remove(temp.size()-1);
        i++;
        while(i>0 && i<candidates.length && candidates[i]==candidates[i-1]) i++;
        rec(candidates, target, i, temp);
    } 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        ans = new ArrayList<>();
        rec(candidates, target, 0, temp);
        return ans;
    }
}