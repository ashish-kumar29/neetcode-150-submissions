class Solution {
    List<String> temp;
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        temp = new ArrayList<>();
        ans = new ArrayList<>();
        palPartition(s, 0);
        return ans;
    }
    private void palPartition(String s, int i){
        if(i==s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i1=i;i1<s.length();i1++){
            if(isPal(s, i, i1)){
                temp.add(s.substring(i,i1+1));
                palPartition(s, i1+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPal(String s, int i, int j){
        while(j>i){
            if(s.charAt(j--)!=s.charAt(i++)) return false;
        }
        return true;
    }
}

// aabbaa
