class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            i=j+1;
            j=i+len;
            String res = str.substring(i, j);
            ans.add(res);
            i=j;
        }
        return ans;
    }
}
