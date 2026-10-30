class Solution {
    String[] words = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        letterComb(digits, 0, new StringBuilder());
        return ans;
    }
    private void letterComb(String digits, int i, StringBuilder comb){
        if(i==digits.length()){
            if(comb.length()>0) ans.add(comb.toString());
            return;
        }
        String s = words[digits.charAt(i)-'0'];
        for(char c:s.toCharArray()){
            comb.append(c);
            letterComb(digits,i+1,comb);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}