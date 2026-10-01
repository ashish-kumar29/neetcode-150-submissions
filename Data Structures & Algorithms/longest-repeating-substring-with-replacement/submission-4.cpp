class Solution {
public:
    int characterReplacement(string s, int k) {
        int hash[26]={0};

        int i=0;

        int j=0;

        int n=s.length();

        int ans=0;

        int maxFreq=0;

        while(j<n){

            hash[s[j]-'A']++;

            maxFreq = max(maxFreq, hash[s[j]-'A']);

            if(j-i+1 - maxFreq <= k){

                ans = max(ans,j-i+1);

            }else{

                if(j-i+1 - maxFreq > k){

                    hash[s[i]-'A']--;

                    maxFreq--;

                    ++i;

                }

            }

            ++j;

        }

        return ans;
 
    }
};
