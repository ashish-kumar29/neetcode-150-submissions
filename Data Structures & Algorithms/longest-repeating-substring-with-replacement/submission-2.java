// XYYX
// k=0
// f=y
// x-2
// y-2
// 012345678
// AAABABBBB
// k=3
// ans=8
// f=B
// k1=0
// i=1
// j=8
// A 3
// B 5
// tot=7

// ABB
// k=1
// f=A
// k1=-1
// A=1
// B=2



class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int k1=k, ans=1;
        char f = 'a';
        int i=0,j=0;
        while(j<s.length()){
            if(f=='a'){
                f=s.charAt(j);
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
                j++;
                continue;
            }
            if(s.charAt(j)==f) freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
            else{
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
                k1--;
            }
            while(k1<0){
                int tot = 0;
                for(char c:freq.keySet()){
                    tot+=freq.get(c);
                    if(freq.get(f)<freq.get(c)) f=c;
                }
                if(tot-freq.get(f)<=k) k1=k-(tot-freq.get(f));
                if(k1>=0) break;
                freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
