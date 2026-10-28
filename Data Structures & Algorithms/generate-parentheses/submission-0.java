class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        createParenthesis(n,0,new StringBuilder());
        return ans;
    }
    public void createParenthesis(int n, int openPar, StringBuilder str){
        if(n==0 && openPar==0){
            ans.add(str.toString());
            return;
        }
        if(n>0){
            str.append('(');
            createParenthesis(n-1, openPar+1, str);
            str.deleteCharAt(str.length() - 1);
        }
        if(openPar>0){
            str.append(')');
            createParenthesis(n, openPar-1,str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
// 3
// 0
// () 2,0 -> ()( 1,1 -> ()() 1,0 -> ()()( 0,1 -> ()()() 0,0
// 				  -> ()(( 0,2 -> ()(() 0,1 -> ()(()) 0,0
// (( 1,2