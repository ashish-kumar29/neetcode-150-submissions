class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            String s1 = s+"0".repeat(200-s.length());
            String len = "0".repeat(3-Integer.toString(s.length()).length())+s.length();
            sb.append(s1).append(len);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            String s1 = str.substring(i, i+200);
            i+=200;
            int len = Integer.parseInt(str.substring(i, i+3));
            ans.add(s1.substring(0, len));
            i+=3;
        }
        return ans;
    }
}
