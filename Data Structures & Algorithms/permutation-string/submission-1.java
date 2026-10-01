// 0123456789
// lecaebacee"
// i=2,j=2
// a-1
// b-1
// c-1
// 

// s1-4  
// 01234567
// abverwrd
// s1 = "abca", s2 = "lecaaabcee"
// s1 = "abc", s2 = "lecaabee"


// 0123
// dcda
// i=0,j=3
// a-1
// d-0
// c-0
// sz=2


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int i=0,j=0;
        Map<Character, Integer> s1Freq = new HashMap<>();
        for(char c: s1.toCharArray()){
            s1Freq.put(c, s1Freq.getOrDefault(c, 0)+1);
        }
        int sz=s1Freq.size();
        while(j<s2.length()){
            if(s2.length()-i<s1.length()) break;
            if(!s1Freq.containsKey(s2.charAt(j))){
                j++;
                while(i<j){
                    if(s1Freq.containsKey(s2.charAt(i))){
                        if(s1Freq.get(s2.charAt(i))==0) sz++;
                        s1Freq.put(s2.charAt(i), s1Freq.get(s2.charAt(i))+1);
                    }
                    i++;
                }
                continue;
            }
            while(s1Freq.get(s2.charAt(j))==0){
                if(s1Freq.get(s2.charAt(i))==0) sz++;
                s1Freq.put(s2.charAt(i), s1Freq.get(s2.charAt(i++))+1);
            }
            s1Freq.put(s2.charAt(j), s1Freq.get(s2.charAt(j))-1);
            if(s1Freq.get(s2.charAt(j++))==0) sz--;
            if(sz==0) return true;

            //for loop in hm and check all 0 or not
        }
        return false;
    }
}
